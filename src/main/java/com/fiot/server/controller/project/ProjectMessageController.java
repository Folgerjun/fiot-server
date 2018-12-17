package com.fiot.server.controller.project;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiot.server.entity.AuthProjectModelEntity;
import com.fiot.server.entity.vo.MessageVo;
import com.fiot.server.service.AuthProjectModelService;
import com.fiot.server.util.constant.ResponseStatus;

@RestController
public class ProjectMessageController {

	@Resource
	AuthProjectModelService authProjectModelService;

	@PostMapping("/project/message")
	public String getProjectMessage(@RequestParam("projectName") String projectName) {
		AuthProjectModelEntity projectEntity = authProjectModelService.findByProjectName(projectName);
		if (projectEntity == null) {
			throw new NullPointerException("找不到该项目：" + projectName);
		}
		return new MessageVo(ResponseStatus.SUCCESS_CODE, "项目名为：" + projectName, projectEntity).toJsonStr();
	}

}
