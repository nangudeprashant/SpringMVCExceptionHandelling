package com.javaLive.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaLive.exception.KeywordNotFoundException;

@Controller
@RequestMapping("/keyword")
public class KeywordController {
	@RequestMapping("/info")
    public String info(@RequestParam(value="key") String key, Model model) {
		if ("key101".equals(key)) {
	       model.addAttribute("msg", "Hello Key World!");
		} else {
			throw new KeywordNotFoundException(key);
		}
        return "success";
	}
}