package com.fiot.server.service;

import com.fiot.server.entity.UserEntity;

/**
 * 用户 service 类
 * 
 * @author ffj
 *
 */
public interface UserService {

	UserEntity findByUserNameAndPassWord(String userName, String passWord);

	boolean saveUser(UserEntity user);

}
