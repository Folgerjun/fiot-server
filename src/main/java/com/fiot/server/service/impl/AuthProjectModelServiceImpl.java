package com.fiot.server.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fiot.server.entity.AuthProjectModelEntity;
import com.fiot.server.repository.AuthProjectMessageRepository;
import com.fiot.server.service.AuthProjectModelService;

@Service("authProjectModelService")
public class AuthProjectModelServiceImpl implements AuthProjectModelService {

	@Resource
	AuthProjectMessageRepository authProjectMessageRepository;

	@Override
	public AuthProjectModelEntity findByProjectName(String projectName) {

		return authProjectMessageRepository.findByProjectName(projectName);
	}

}
