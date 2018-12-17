package com.fiot.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.fiot.server.datasource.DynamicDataSourceRegister;

@SpringBootApplication
@Import(DynamicDataSourceRegister.class)
public class ServerApplication {
	private static Logger logger = LoggerFactory.getLogger(ServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
		logger.info("启动成功！");

	}
}
