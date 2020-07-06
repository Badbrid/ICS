package com.example.liang.setting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.liang.setting.dao.mapper")
public class SystemSettingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemSettingApplication.class, args);
	}

}
