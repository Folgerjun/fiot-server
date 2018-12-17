package com.fiot.server.entity;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户表
 * 
 * @author ffj
 *
 */
@Data
@AllArgsConstructor
@Document(collection = "USER")
public class UserEntity {

	/**
	 * 用户名
	 */
	@Id
	private String userName;
	/**
	 * 密码
	 */
	private String passWord;
	/**
	 * 权限
	 */
	private List<String> authorizations;
}
