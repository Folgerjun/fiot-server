package com.fiot.server.datasource;

import org.springframework.util.StringUtils;

public class DataSourceUtil {

	private static final String JDBC_URL_ARGS = "?characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";

	/**
	 * 拼接完整的JDBC URL
	 */
	public static String getJDBCUrl(String baseUrl) {
		if (!StringUtils.hasText(baseUrl)) {
			return null;
		}
		return baseUrl + JDBC_URL_ARGS;
	}

}