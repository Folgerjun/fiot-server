package com.fiot.server.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fiot.server.entity.UserEntity;
import com.fiot.server.repository.UserRepository;
import com.fiot.server.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	@Override
	public UserEntity findByUserNameAndPassWord(String userName, String passWord) {
		UserEntity user = userRepository.findByUserNameAndPassWord(userName, passWord);
		return user;
	}

	@Override
	public boolean saveUser(UserEntity user) {
		UserEntity entity = userRepository.save(user);
		System.out.println("插入的数据为：" + entity);
		if (StringUtils.isEmpty(entity)) {
			return false;
		}
		return true;
	}

}
