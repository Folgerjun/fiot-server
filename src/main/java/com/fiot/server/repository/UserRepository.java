package com.fiot.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiot.server.entity.UserEntity;

/**
 * 用户表接口类
 * 
 * @author ffj
 *
 */
public interface UserRepository extends MongoRepository<UserEntity, String> {

	/**
	 * 根据用户名和密码查询用户
	 * 
	 * @param userName
	 *            用户名
	 * @param passWord
	 *            密码
	 * @return
	 */
	UserEntity findByUserNameAndPassWord(String userName, String passWord);

}
