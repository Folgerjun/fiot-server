package com.fiot.server.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 对应每个项目的模型数据表
 * 
 * @author ffj
 *
 */
@Data
@AllArgsConstructor
@Document(collection = "Auth_Project_Model")
public class AuthProjectModelEntity {

	/**
	 * 对应的项目
	 */
	@Id
	private String projectName;
	/**
	 * 项目对应的模型数据表名
	 */
	private String modelCollectionName;
	/**
	 * 项目介绍
	 */
	private String introduction;
	/**
	 * 项目 logo 名字
	 */
	private String logoName;
	/**
	 * 项目图片名字
	 */
	private String imgName;
}
