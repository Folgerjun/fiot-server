package com.fiot.server.entity.vo;
/**
 * 接口数据传输类
 * @author ffj
 *
 */

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8168199516755662754L;
	/**
	 * 状态码 200：成功处理请求 500：未成功处理请求
	 */
	private int code;
	/**
	 * 信息
	 */
	private String message;
	/**
	 * 对象参数
	 */
	private Object obj;

	/**
	 * 转为 json 字符串
	 * 
	 * @return
	 */
	public String toJsonStr() {
		return JSON.toJSONString(this);
	}

}
