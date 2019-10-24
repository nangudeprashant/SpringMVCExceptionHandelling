package com.javaLive.controller;
import java.io.IOException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.javaLive.exception.KeywordNotFoundException;
@ControllerAdvice
public class GlobalExceptionHandler {
	  @ExceptionHandler(IOException.class)
	  public ModelAndView myError(Exception exception) {
	    System.out.println("----Caught IOException----");
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", exception);
	    mav.setViewName("globalerror");
	    return mav;
	  }
	  @ExceptionHandler(KeywordNotFoundException.class)
	  public String notFound() {
            System.out.println("----Caught KeywordNotFoundException----");
            return "404";
	  }
} 