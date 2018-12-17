package com.fiot.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiot.server.entity.AuthProjectModelEntity;

/**
 * 项目信息表接口
 * 
 * @author ffj
 *
 */
public interface AuthProjectMessageRepository extends MongoRepository<AuthProjectModelEntity, String> {

	/**
	 * 根据项目名查询
	 * 
	 * @param projectName
	 * @return
	 */
	AuthProjectModelEntity findByProjectName(String projectName);

}
