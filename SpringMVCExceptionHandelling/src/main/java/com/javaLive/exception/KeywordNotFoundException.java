package com.javaLive.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Keyword")
public class KeywordNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public KeywordNotFoundException(String key){
		super(key+" not available");
	}
} 
