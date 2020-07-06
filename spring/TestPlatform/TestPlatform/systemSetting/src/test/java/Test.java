import com.example.liang.setting.commons.utils.SecretUtil;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/7/3 14:38
 */
public class Test {

    SecretUtil secretUtil = new SecretUtil();

    public static void main(String[] args) {
        System.out.println(SecretUtil.MD5("!QAZ1qaz").toString());
    }
}
