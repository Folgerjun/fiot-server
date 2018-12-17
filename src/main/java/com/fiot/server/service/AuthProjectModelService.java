package com.fiot.server.service;

import com.fiot.server.entity.AuthProjectModelEntity;

public interface AuthProjectModelService {
	AuthProjectModelEntity findByProjectName(String projectName);
}
