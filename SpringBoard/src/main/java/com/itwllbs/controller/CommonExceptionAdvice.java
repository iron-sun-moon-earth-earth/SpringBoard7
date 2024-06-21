package com.itwllbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 예외처리(보조기능-AOP)를 수행하는 객체
 */
@ControllerAdvice
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	//@ExceptionHandler(NullPointerException.class)
//	@ExceptionHandler(Exception.class)	//exception이 발생했을때 실행되는 메서드	
//	public String /*void*/ testException(Exception e, Model model) {
//		logger.debug("testException() 실행");
//			logger.debug("Exception(예외) 발생!!!!!");
//			logger.debug("testException() 실행");
//			logger.debug("e: " + e);
//			
//			model.addAttribute("e", e);
//			
//			return "commonException";
//	}
	
	@ExceptionHandler(Exception.class)	
	public ModelAndView testException2(Exception e) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/commonException");
		mav.addObject("e", e);
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
