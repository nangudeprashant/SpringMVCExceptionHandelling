package com.javaLive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaLive.exception.ElectricityNotFoundException;


@Controller
@RequestMapping("/myvillage")
public class VillageController {
	  @RequestMapping("/info")
	  public String myInfo(@RequestParam(value="vid") String vid, Model model) throws Exception {
		if ("111".equals(vid)) {
		    throw new ElectricityNotFoundException("Dhananajaypur");
		}else if ("222".equals(vid)) {
		    throw new NullPointerException("Data not found.");
		}else {
			model.addAttribute("msg", "Welcome to My Village.");
		}
	        return "success";
	  }
}
