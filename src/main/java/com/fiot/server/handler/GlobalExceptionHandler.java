package com.fiot.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fiot.server.entity.vo.MessageVo;
import com.fiot.server.util.constant.ResponseStatus;

/**
 * 全局异常处理
 * 
 * @author ffj
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 定义全局空指针异常·
	 * 
	 * @param ex
	 */
	@ExceptionHandler(value = NullPointerException.class)
	public String exceptionNPE(NullPointerException ex) {
		log.info("NPE:" + ex.getMessage());
		return new MessageVo(ResponseStatus.FAIL_CODE, ex.getMessage(), null).toJsonStr();
	}

}
