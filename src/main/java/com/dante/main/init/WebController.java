package com.dante.main.init;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WebController {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@GetMapping(value="/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		List<String> listTest = new ArrayList<>();
         
        listTest.add("test1");
        listTest.add("test2");
        listTest.add("test3");
        mv.addObject("listTest",listTest);
        mv.setViewName("index");
		return mv;
	}
	/*@GetMapping(value="/")
	public String index() {
		//ModelAndView mv = new ModelAndView();
		List<String> listTest = new ArrayList<>();
         
        listTest.add("test1");
        listTest.add("test2");
        listTest.add("test3");
        //mv.addObject("listTest",listTest);
        //mv.setViewName("index");
		return "/index";
	}*/
}
