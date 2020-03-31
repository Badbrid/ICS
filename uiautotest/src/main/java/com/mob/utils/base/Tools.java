package com.mob.utils.base;

import org.apache.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.*;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/16 14:20
 */
public class Tools {
    private static Logger logger = Logger.getLogger(Tools.class);

    //获取本地IP地址
    public static String getLocalIpAddr() {

        String clientIP = null;
        Enumeration<NetworkInterface> networks = null;
        try {
            //获取所有网卡设备
            networks = NetworkInterface.getNetworkInterfaces();
            if (networks == null) {
                //没有网卡设备 打印日志  返回null结束
                System.out.printf("networks  is null");
                return null;
            }
        } catch (SocketException e) {
            System.out.println(e.getMessage());
        }
        InetAddress ip;
        Enumeration<InetAddress> addrs;
        // 遍历网卡设备
        while (networks.hasMoreElements()) {
            NetworkInterface ni = networks.nextElement();
            try {
                //过滤掉 loopback设备、虚拟网卡
                if (!ni.isUp() || ni.isLoopback() || ni.isVirtual()) {
                    continue;
                }
            } catch (SocketException e) {
                System.out.printf("", e.getMessage());
            }
            addrs = ni.getInetAddresses();
            if (addrs == null) {
                System.out.printf("", "InetAddress is null");
                continue;
            }
            // 遍历InetAddress信息
            while (addrs.hasMoreElements()) {
                ip = addrs.nextElement();
                if (!ip.isLoopbackAddress() && ip.isSiteLocalAddress() && ip.getHostAddress().indexOf(":") == -1) {
                    try {
                        clientIP = ip.toString().split("/")[1];
                        if (clientIP.contains("172")) {
                            return clientIP;
                        }
                        System.out.printf(clientIP);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        clientIP = null;
                    }
                }
            }
        }
        return clientIP;

    }

    /*
    * 获取指定apk的绝对路径
    */
    public static String appPath(String apkName){
        //安卓apk文件路径
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "src/main/java/com/mob/utils/apps");
        File app = new File(appDir, apkName);
        if(app.exists()){
            String absolutePath = app.getAbsolutePath();
            logger.info("apk 路径: " + absolutePath);
            return absolutePath;
        }else {
            logger.info("apk 不存在，请上传apk ");
            return null;
        }

    }

    /*
    * 获取配置文件里的apk参数
    * 把所有参数放到map里
    */
    public static Map getYaml(String yamlName){
        try {
            Yaml yaml = new Yaml();
            File ymlFile = new File(System.getProperty("user.dir") + "/src/main/resources/configure/" + yamlName);
            if (ymlFile != null) {
                Map map = null;

                map = yaml.load(new FileInputStream(ymlFile));
                logger.info(map);
                return map;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取随机安卓uid
     * @return
     */
    public static String getRandomAndroidDeviceId(){
        String id = null;
        List<String> ids = getAndroidDevicesIds();
        if(ids != null && ids.size() > 0){
            int i = new Random().nextInt(ids.size());
            id = ids.get(i) ;
        }
        return id;
    }

    /**
     * 获取安卓uid列表
     * @return
     */
    public static List<String> getAndroidDevicesIds(){
        List<String> deviceIds = new ArrayList<>();
        List<String> al  = runExec("adb devices");
        if (al.size() > 0) {
            for (int i =1; i < al.size() ;i++){
                String tmpStr = al.get(i);
                if(tmpStr != null && tmpStr.contains("device")){
                    tmpStr = tmpStr.replace("device","").trim();
                    deviceIds.add(tmpStr);
                }
            }
        }
        return deviceIds;
    }

    /**
     * 运行命令行
     * @param cmd
     * @return
     */
    public static List<String> runExec(String cmd){
        List<String> list = new ArrayList<>();
        String line = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(cmd);
            InputStream inputStream = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = bufferedReader.readLine()) != null){
                list.add(line);
                logger.debug(line);
            }
        } catch (Throwable throwable){
            throwable.printStackTrace();
            return null;
        }
        return list;
    }

    /**
     * 获取对应安卓的release版本
     * @param uid
     * @return
     */
    public static String getDeviceRelease(String uid){
        String deviceRelease = "";
        List<String> al = runExec("adb -s " + uid + " shell getprop ro.build.version.release");
        if(al != null && al.size() > 0){
            deviceRelease = al.get(0);
        }
        logger.info("安卓设备平台版本：" + deviceRelease + "\n");
        return deviceRelease;
    }

    public static void main(String[] args) {
        System.out.println(Tools.getRandomAndroidDeviceId());
    }
}
