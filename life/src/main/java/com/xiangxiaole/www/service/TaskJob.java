package com.xiangxiaole.www.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xiangxiaole.util.tool.MyLog;

@Component("taskJob") 
public class TaskJob {
	@Autowired MfmcService mfmcService;
	@Autowired NewsService newsService;
	
	/*
	 * 北京存量房签约统计
	 */
	@Scheduled(cron = "0 15 17 * * *")
	public void queryHouseSign() throws IOException{
		MyLog.taskLogger.info("北京存量房签约统计开始");
		mfmcService.parseHouseSign();
		MyLog.taskLogger.info("北京存量房签约统计结束");
	}
	
	/*
	 * 天涯热帖
	 */
	@Scheduled(cron = "0 46 18 * * *")
	public void queryTianyaHot() throws IOException{
		MyLog.taskLogger.info("天涯热帖爬取开始");
		newsService.parseTianyaHot();
		MyLog.taskLogger.info("天涯热帖爬取结束");
	}

}
