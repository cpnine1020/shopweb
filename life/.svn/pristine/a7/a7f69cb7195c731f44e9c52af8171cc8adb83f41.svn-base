package com.xiangxiaole.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xiangxiaole.www.service.MfmcService;

@Controller
public class MfmcController {
	
	@Autowired
	private MfmcService mfmcService;
	
	/*
	 * 存量房签约查询
	 */
	@RequestMapping(value="/mfmc-housesignquery")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("houseSignList", mfmcService.queryRecentHouseSign());
		mv.setViewName("mfmc-housesignquery");
		return mv;	
	}
}
