package com.example.liang.setting.commons.il8n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/6/29 18:49
 */
@Component
public class ConvertLanguage {

    @Autowired
    private MessageSource messageSource;


    public String get(String key){
        return messageSource.getMessage(key,null,"Not Support Key", LocaleContextHolder.getLocale());

    }
}
