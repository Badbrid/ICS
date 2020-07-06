package com.example.liang.setting.commons.security;

import com.alibaba.fastjson.JSONObject;
import com.example.liang.setting.controller.response.DataResult;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/6/28 18:15
 * @descript 没有权限时的，无权操作
 */
public class LoginFilter extends FormAuthenticationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest request , ServletResponse response , Object mappedValue){
        if(((HttpServletRequest) request).getMethod().toLowerCase().equals("OPTIONS")){
            return true;
        }
        return super.isAccessAllowed(request,response,mappedValue);
    }

    @Override
    public boolean onAccessDenied(ServletRequest request , ServletResponse response) throws IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if(httpServletRequest.getServletPath().endsWith("login")){
            return onAccessDenied(request,response);
        }
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setHeader("authentication-status","invalid");
        DataResult result = DataResult.error("Authentication Status Invalid");
        httpServletResponse.getWriter().write(JSONObject.toJSON(result).toString());
        return true;
    }
}
