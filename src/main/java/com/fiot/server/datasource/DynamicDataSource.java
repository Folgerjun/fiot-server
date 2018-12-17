package com.fiot.server.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态切换数据源
 * 
 * AbstractRoutingDataSource(每执行一次数据库，动态获取DataSource)
 * 
 * @author ffj
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	private static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);

	@Override
	protected Object determineCurrentLookupKey() {
		log.info("------当前数据源为------" + DataSourceContextHolder.getDataSourceKey());
		return DataSourceContextHolder.getDataSourceKey();
	}

}
