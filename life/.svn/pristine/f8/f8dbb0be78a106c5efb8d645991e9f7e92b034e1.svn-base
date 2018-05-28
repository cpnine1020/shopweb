package com.xiangxiaole.www.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.xiangxiaole.util.tool.Formatter;
import com.xiangxiaole.util.tool.MyLog;
import com.xiangxiaole.www.dao.HouseSignMapper;
import com.xiangxiaole.www.model.HouseSign;

/*
 * 买房买车栏目service
 */
@Service 
public class MfmcService {

	@Autowired
	private HouseSignMapper houseSignMapper;
	
	
	/*
	 * 解析存量房签约和核验页面
	 */
	public boolean parseHouseSign() throws IOException{
		Document doc = Jsoup.connect("http://210.75.213.188/shh/portal/bjjs/index.aspx").timeout(0).get();
		HouseSign houseSign = new HouseSign();
		houseSign.setCity("北京");
		houseSign.setUpdateTime(new Date());
		houseSign.setSignDate(Formatter
				.StrToDate(doc.select("th[colspan=2]:contains(核验房源)").text().replace("核验房源", ""), "yyyy-MM-dd"));//签约日期
		
		houseSign.setWebCheckNum(Integer.valueOf(doc.select("tr:contains(核验房源套数)>td").text()));//核验房源套数
		houseSign.setWebCheckSize(Float.valueOf(doc.select("tr:contains(核验房源面积)>td").text()));//核验房源面积
		houseSign.setHouseCheckNum(Integer.valueOf(doc.select("tr:contains(核验住宅套数)>td").text()));//核验住宅套数
		houseSign.setHouseCheckSize(Float.valueOf(doc.select("tr:contains(核验住宅面积)>td").text()));//核验住宅面积
		
		houseSign.setWebSignNum(Integer.valueOf(doc.select("tr:contains(网上签约套数)>td").last().text()));//网上签约套数
		houseSign.setWebSignSize(Float.valueOf(doc.select("tr:contains(网上签约面积)>td").last().text()));//网上签约面积
		houseSign.setHouseSignNum(Integer.valueOf(doc.select("tr:contains(住宅签约套数)>td").last().text()));//住宅签约套数
		houseSign.setHouseSignSize(Float.valueOf(doc.select("tr:contains(住宅签约面积)>td").last().text()));//住宅签约面积
		
		HouseSign h = houseSignMapper.selectBySignDateAndCity(houseSign);
		if(h==null){//未抓取过 插入
			houseSignMapper.insert(houseSign);
			MyLog.taskLogger.info("插入北京存量房签约记录："+houseSign.getSignDate());
		}else{//更新
			houseSign.setId(h.getId());
			houseSignMapper.updateByPrimaryKey(houseSign);
			MyLog.taskLogger.info("更新北京存量房签约记录："+houseSign.getSignDate());
		}
		return true;
	}
	
	/*
	 * 查询最近的一年存量房签约记录
	 */
	public List<HouseSign> queryRecentHouseSign(){
		return houseSignMapper.queryRecentHouseSign();
	}
	
	
	
	
	
	public static void main(String [] args) throws IOException{
		ApplicationContext context = new ClassPathXmlApplicationContext( 
		        new String[] {"spring-mvc.xml"}); 
		MfmcService m = context.getBean(MfmcService.class); 
		m.parseHouseSign();
	}
}
