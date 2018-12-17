package com.fiot.server.datasource;

import java.util.ArrayList;
import java.util.List;

public class DataSourceContextHolder {
	/**
	 * 多线程存放数据源
	 */
	private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<>();

	/**
	 * 存放数据源 key
	 */
	public static List<String> dataSourceIds = new ArrayList<String>();

	/**
	 * 设置数据源
	 * 
	 * @param tenantKey
	 */
	public static void setDataSourceKey(String tenantKey) {
		dataSourceKey.set(tenantKey);
	}

	/**
	 * 获取数据源
	 * 
	 * @return
	 */
	public static String getDataSourceKey() {

		return dataSourceKey.get();
	}

	/**
	 * 清楚数据源
	 */
	public static void clearDataSourceKey() {
		dataSourceKey.remove();
	}

	/**
	 * 判断当前数据源是否存在
	 * 
	 * @param dataSourceKey
	 * @return
	 */
	public static boolean isContainsDataSource(String dataSourceKey) {
		return dataSourceIds.contains(dataSourceKey);
	}

}
