package com.ningx.stock.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ningx.stock.service.Candle;
import com.ningx.stock.service.StockhqService;
import com.ningx.stock.util.tool.MyLog;

@Controller
public class TestController {
	
	@Autowired
	private StockhqService stockhqService;
	
	@RequestMapping(value="index")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;	
	}
	@RequestMapping(value="/")
	public ModelAndView index1(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;	
	}
	
	@RequestMapping(value="/testCandle")
	@ResponseBody
	public Object testCandle(String market){
		if(market.equals("sh")){
			String code = "";
			for(int i = 0;i<4500;i++){//600001-601999  603000-604500
				if(i<10){
					code = "60000"+i;
				}else if(i<100){
					code = "6000"+i;
				}else if(i<1000){
					code = "600"+i;
				}else if(i<2000||i>2999){
					code = "60"+i;
				}else{
					continue;
				}
				if(Candle.isChuiZiXian(stockhqService.queryRecentStockhq(code, 4))){
					System.out.println(code+" YES");
					break;
				}else{
					System.out.println(code+" NO");
				}
			}

		}else if(market.equals("sz")){
			System.out.println("SZ开始："+new Date());
			MyLog.hqimportLogger.info("导入SZ行情数据开始");
			String code = "";
			for(int i = 0;i<3000;i++){//000001-000999   001600-003000
				if(i<10){
					code = "sz00000"+i;
				}else if(i<100){
					code = "sz0000"+i;
				}else if(i<1000){
					code = "sz000"+i;
				}else if(i>1600){
					code = "sz00"+i;
				}else{
					continue;
				}
				stockhqService.getHqFromWeb(code);
			}
			
			for(int k = 0;k<3000;k++){//300000-300600
				if(k<10){
					code = "sz30000"+k;
				}else if(k<100){
					code = "sz3000"+k;
				}else if(k<600){
					code = "sz300"+k;
				}else{
					continue;
				}
				stockhqService.getHqFromWeb(code);
			}
			
			System.out.println("SZ结束："+new Date());
			MyLog.hqimportLogger.info("导入SZ行情数据结束");
		}
		
		return "success";
	}

	
	
}
