package com.xiangxiaole.www.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xiangxiaole.util.page.Page;
import com.xiangxiaole.www.model.News;
import com.xiangxiaole.www.service.NewsService;

@Controller
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	/*
	 * 天涯热帖榜
	 */
	@RequestMapping(value="/news-tianyahot")
	public ModelAndView tianyahot(){
		ModelAndView mv = new ModelAndView();
		
		Page<News> page = new Page<News>(1,15);
		Map<String,Object> params = new HashMap<String,Object>();
		News condition = new News();
		condition.setSourceSite("天涯论坛");
		params.put("news", condition);
		page.setParams(params);
		
		mv.addObject("newsList",newsService.queryNewsByPage(page));
		mv.setViewName("news-tianyahot");
		return mv;	
	}
	
	/*
	 * 新闻内容页
	 */
	@RequestMapping(value="/news-newscontent")
	public ModelAndView newscontent(int id){
		ModelAndView mv = new ModelAndView();
		mv.addObject("news",newsService.queryNewsById(id));
		mv.addObject("lastNews", newsService.queryLastNews(id));
		mv.addObject("nextNews", newsService.queryNextNews(id));
		mv.setViewName("news-newscontent");
		return mv;	
	} 
}
