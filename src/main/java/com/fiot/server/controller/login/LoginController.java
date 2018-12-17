package com.fiot.server.controller.login;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiot.server.entity.UserEntity;
import com.fiot.server.entity.vo.MessageVo;
import com.fiot.server.service.UserService;
import com.fiot.server.util.constant.ResponseStatus;

@RestController
public class LoginController {

	@Resource
	private UserService userService;

	@PostMapping("/user/login")
	public String login(@RequestParam("username") String userName, @RequestParam("password") String passWord) {
		// 页面已经判断过不为空 故无需再判
		System.out.println("before -> username :" + userName + " ,password :" + passWord);
		UserEntity user = userService.findByUserNameAndPassWord(userName, passWord);
		if (user == null) {
			throw new NullPointerException("请输入正确的用户名密码！");
		}
		System.out.println("after -> :" + user);
		return new MessageVo(ResponseStatus.SUCCESS_CODE, "登陆成功", user.getAuthorizations()).toJsonStr();

	}

	@PutMapping("/user/save")
	public String saveUser(@RequestParam("username") String userName, @RequestParam("password") String passWord) {
		System.out.println("save -> username :" + userName + " ,password :" + passWord);
		boolean saved = userService.saveUser(new UserEntity(userName, passWord, new ArrayList<String>()));

		if (saved) {
			System.out.println("已保存");
			return new MessageVo(ResponseStatus.SUCCESS_CODE, "已保存", null).toJsonStr();
		}

		System.out.println("没保存");
		return new MessageVo(ResponseStatus.FAIL_CODE, "没保存", null).toJsonStr();
	}

}
