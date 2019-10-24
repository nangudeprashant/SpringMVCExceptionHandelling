package com.javaLive.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/myworld")
public class MyWorldExceptionController {
	  @ResponseStatus(value=HttpStatus.CONFLICT, reason="Data already present")
	  @ExceptionHandler(SQLException.class)
	  public void dataConflict() {
	    System.out.println("----Caught SQLException----");
	  }
	  @ExceptionHandler(FileNotFoundException.class)
	  public ModelAndView myError(Exception exception) {
	    System.out.println("----Caught FileNotFoundException----");
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exc", exception);
	    mav.setViewName("myerror");
	    return mav;
	  }
	  @RequestMapping("/check")
	  public String myInfo(@RequestParam(value="id") String id, Model model) throws Exception {
		if ("1".equals(id)) {
		    throw new SQLException();
		}else if ("2".equals(id)) {
		    throw new FileNotFoundException("File not found.");
		}else if ("3".equals(id)) {
		    throw new IOException("Found IO Exception");
		}else {
			model.addAttribute("msg", "Welcome to My World.");
		}
	        return "success";
	  }
} 
