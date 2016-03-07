package com.xiezhaoxin.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(HttpServerErrorException.class)
	public @ResponseBody ReturnMessage handleHttpServerErrorException(HttpServletRequest request, HttpServletResponse response, HttpServerErrorException ex) {
		// 日志处理
		logger.error("跨域访问异常::URL=" + request.getRequestURL());
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ReturnMessage(ex.getStatusText(), ex.getResponseBodyAsString());
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public @ResponseBody ReturnMessage handleHttpClientErrorException(HttpServletRequest request, HttpServletResponse response, HttpClientErrorException ex) {
		// 日志处理
		logger.error("跨域访问异常::URL=" + request.getRequestURL());
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ReturnMessage(ex.getStatusText(), ex.getResponseBodyAsString());
	}
	
//    if (exception instanceof HttpServerErrorException) {
//        HttpServerErrorException e = (HttpServerErrorException) exception;
//        return new ErrorHolder(e.getStatusCode(), e.getStatusText(), e.getResponseBodyAsString());
//    }
//
//    if (exception instanceof HttpClientErrorException) {
//        HttpClientErrorException e = (HttpClientErrorException) exception;
//        return new ErrorHolder(e.getStatusCode(), e.getStatusText(), e.getResponseBodyAsString());
//    }
}