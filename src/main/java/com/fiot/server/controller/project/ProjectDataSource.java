package com.fiot.server.controller.project;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiot.server.datasource.DataSourceContextHolder;
import com.fiot.server.entity.vo.MessageVo;
import com.fiot.server.repository.mysql.UserMysqlRepository;

/**
 * 项目数据源切换
 * 
 * @author ffj
 *
 */
@RestController
public class ProjectDataSource {

	private static final Logger log = LoggerFactory.getLogger(ProjectDataSource.class);

	@Resource
	private UserMysqlRepository userMysqlRepository;

	@PostMapping("/project/switch")
	public String switchDataSource(String projectName) {
		log.info("-------------------");
		log.info("projectName:" + projectName);
		DataSourceContextHolder.setDataSourceKey(projectName);
		log.info(userMysqlRepository.findAll().get(0).toString());
		DataSourceContextHolder.clearDataSourceKey();
		return new MessageVo(200, "切换至对应项目数据源", null).toJsonStr();
	}

}
