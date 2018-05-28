package com.xiangxiaole.www.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.xiangxiaole.util.page.Page;
import com.xiangxiaole.util.tool.Formatter;
import com.xiangxiaole.util.tool.MyLog;
import com.xiangxiaole.www.dao.NewsMapper;
import com.xiangxiaole.www.model.News;

/*
 * 看新闻逛论坛
 */
@Service
public class NewsService {

	@Autowired
	private NewsMapper newsMapper;
	
	/*
	 * 爬虫解析天涯热帖
	 */
	public boolean parseTianyaHot() throws IOException{
		Document doc = Jsoup.connect("http://bbs.tianya.cn").timeout(0).get();
		Elements els = doc.select("div[_tystat=热帖榜]>ul.curr>li[class!=li-line]");
		for(int i=els.size()-1;i>=0;i--){
			Element el = els.get(i);
			News news = new News();
			news.setSourceSite("天涯论坛");
			news.setType1("帖子");
			news.setType2(el.select("span>a").text());//小分类
			news.setTitle(el.select("div.title>a").text());	//标题		
			news.setUrl("http://bbs.tianya.cn"+el.select("div.title>a").attr("href"));//原帖地址
			
			//进入主帖，继续爬取信息
			doc = Jsoup.connect(news.getUrl()).timeout(0).get();
			Elements els2 = doc.select("#post_head div.atl-info>span");
			news.setAuthor(els2.get(0).select("a").text());//作者
			news.setPublishTime(Formatter.StrToDate(els2.get(1).text().trim().replace("时间：", ""), "yyyy-MM-dd HH:mm:ss"));//发帖时间
			news.setReadNum(Integer.valueOf(els2.get(2).text().trim().replace("点击：", "")));//点击次数
			news.setCommentNum(Integer.valueOf(els2.get(3).text().trim().replace("回复：", "")));//回复次数
			news.setContent(doc.select("div.host-item div.bbs-content").html().replace("src=", "s=").replace("original=", "src="));//帖子内容
			news.setUpdateTime(new Date());//爬取时间
			try {
				Thread.sleep(1000);//这样能严格区分出时间
			} catch (InterruptedException e) {
			}
			Page<News> page = new Page<News>();
			Map<String,Object> params = new HashMap<String,Object>();
			News condition = new News();
			condition.setUrl(news.getUrl());
			params.put("news", condition);
			page.setParams(params);
			
			List<News> list = newsMapper.selectByPage(page);
			if(list.isEmpty()){//未抓取过 ,插入
				newsMapper.insert(news);
				MyLog.taskLogger.info("插入天涯热帖："+news.getTitle());
			}else{
				news.setId(list.get(0).getId());
				newsMapper.updateByPrimaryKeyWithBLOBs(news);
				MyLog.taskLogger.info("更新天涯热帖："+news.getTitle());
			}
			
			
			
		}
		return true;
	}
	
	/*
	 * 分页查询新闻
	 */
	public List<News> queryNewsByPage(Page<News> page){
		return newsMapper.selectByPage(page);
	}
	
	/*
	 * 根据id查询新闻
	 */
	public News queryNewsById(int id){
		return newsMapper.selectByPrimaryKey(id);
	}
	
	/*
	 * 上一篇新闻
	 */
	public News queryLastNews(int id){
		News curr = newsMapper.selectByPrimaryKey(id);
		return newsMapper.selectLast(curr);
	}
	
	/*
	 * 下一篇新闻
	 */
	public News queryNextNews(int id){
		News curr = newsMapper.selectByPrimaryKey(id);
		return newsMapper.selectNext(curr);
	}
	
	
	
	
	public static void main(String [] args) throws IOException{
		ApplicationContext context = new ClassPathXmlApplicationContext( 
		        new String[] {"spring-mvc.xml"}); 
		NewsService m = context.getBean(NewsService.class); 
		m.parseTianyaHot();
	}
}
