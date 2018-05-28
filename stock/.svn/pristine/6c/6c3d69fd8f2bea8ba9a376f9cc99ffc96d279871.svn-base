package com.ningx.stock.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ningx.stock.dao.StockhqMapper;
import com.ningx.stock.model.Stockhq;
import com.ningx.stock.util.net.HttpClient;
import com.ningx.stock.util.tool.Formatter;
import com.ningx.stock.util.tool.MyLog;

/**
 *  行情服务
 */
@Service
public class StockhqService {
	
	@Autowired
	private StockhqMapper stockhqMapper;
	
	/*从腾讯获取行情
	 * http://qt.gtimg.cn/q=sh600000
	 * http://qt.gtimg.cn/q=sh600000,sz000030
	 * v_sh600000="1~浦发银行~600000~15.12（现价）~14.25（昨收）~14.65（今开）~6327818（总量）~3369024~2958794~15.11（买一）
	 * ~5132~15.10~5773~15.09~1326~15.08~1226~15.07~1488~15.12~6558~15.13~502~15.14~5013~15.15~8982~15.16~2418
	 * ~15:00:04/15.12/155/B/234345/12889|14:59:59/15.11/1160/S/1753109/12881|14:59:49/15.12/969/B/1464957/12876|14:59:49/15.12/448/B/677356/12869|14:59:44/15.12/1310/B/1981023/12864|14:59:39/15.12/1130/B/1709501/12858
	 * ~20150312150304（时间）~0.87（涨跌）~6.11（涨幅）~15.56（最高）~14.58（最低）
	 * ~15.11/6327663/9511796126~6327818~951203（总额）~4.24（换手率）~6.14（市盈率）~~15.56~14.58~6.88（振幅）
	 * ~2256.33（流通值）~2820.41（总市值）~1.22（市净率）~15.68（涨停）~12.83（跌停）~";
	 */
	@Transactional
	public Stockhq getHqFromWeb(String stockCode){
		
		String hqStr = HttpClient.get("http://qt.gtimg.cn/q="+stockCode);
		if(!hqStr.contains("\"")){
			System.out.println("没有:"+stockCode);
			MyLog.hqimportLogger.info("没有:"+stockCode);
			return null;
		}
		Stockhq stockhq = new Stockhq();
		try{
			hqStr = hqStr.split("\"")[1];
			String[] hq = hqStr.split("~");
			
			stockhq.setMarket(hq[0]);//市场
			stockhq.setStockname(hq[1]);//名称
			stockhq.setStockcode(hq[2]);//代码
			stockhq.setXj(Float.valueOf(hq[3]));//现价
			stockhq.setZrsp(Float.valueOf(hq[4]));//昨收
			stockhq.setJrkp(Float.valueOf(hq[5]));//开盘
			stockhq.setZl(Float.valueOf(hq[6]));//总量
			
			
			
			stockhq.setHqtime(Formatter.StrToDate(hq[30], "yyyyMMddHHmmss"));//行情时间 30
			stockhq.setHqdate(hq[30].substring(0, 8));
			
			if(stockhq.getXj()==0){
				System.out.println("废弃:"+stockhq.getHqdate()+" "+stockhq.getStockcode()+" "+stockhq.getStockname());
				MyLog.hqimportLogger.warn("废弃:"+stockhq.getStockcode()+" "+stockhq.getHqdate()+" "+stockhq.getStockname());
				return null;
			}
			stockhq.setZd(Float.valueOf(hq[31]));//涨跌
			stockhq.setZdf(Float.valueOf(hq[32]));//涨跌幅
			stockhq.setHigh(Float.valueOf(hq[33]));//最高
			stockhq.setLow(Float.valueOf(hq[34]));//最低
			stockhq.setZe(Float.valueOf(hq[37]));//总金额
			stockhq.setHsl(Float.valueOf(hq[38]));//换手率
			if(hq[39].equals("")){
				stockhq.setPe(Float.valueOf(0));//市盈率（静态）
			}else{
				stockhq.setPe(Float.valueOf(hq[39]));//市盈率（静态）
			}
			stockhq.setZf(Float.valueOf(hq[43]));//振幅
			stockhq.setLtz(Float.valueOf(hq[44]));//流通值
			stockhq.setZsz(Float.valueOf(hq[45]));//总市值
			stockhq.setPb(Float.valueOf(hq[46]));//市净率
			stockhq.setZt(Float.valueOf(hq[47]));//涨停
			stockhq.setDt(Float.valueOf(hq[48]));//跌停
			stockhq.setUpdatetime(new Date());//更新时间
			
			/*5档行情*/
			stockhq.setBp1(Float.valueOf(hq[9]));
			stockhq.setBc1(Integer.valueOf(hq[10]));
			stockhq.setBp2(Float.valueOf(hq[11]));
			stockhq.setBc2(Integer.valueOf(hq[12]));
			stockhq.setBp3(Float.valueOf(hq[13]));
			stockhq.setBc3(Integer.valueOf(hq[14]));
			stockhq.setBp4(Float.valueOf(hq[15]));
			stockhq.setBc4(Integer.valueOf(hq[16]));
			stockhq.setBp5(Float.valueOf(hq[17]));
			stockhq.setBc5(Integer.valueOf(hq[18]));
			stockhq.setSp1(Float.valueOf(hq[19]));
			stockhq.setSc1(Integer.valueOf(hq[20]));
			stockhq.setSp2(Float.valueOf(hq[21]));
			stockhq.setSc2(Integer.valueOf(hq[22]));
			stockhq.setSp3(Float.valueOf(hq[23]));
			stockhq.setSc3(Integer.valueOf(hq[24]));
			stockhq.setSp4(Float.valueOf(hq[25]));
			stockhq.setSc4(Integer.valueOf(hq[26]));
			stockhq.setSp5(Float.valueOf(hq[27]));
			stockhq.setSc5(Integer.valueOf(hq[28]));
			
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("报错的返回:"+hqStr);
			MyLog.hqimportLogger.error("报错的返回:"+hqStr);
		}
		
		
		
		Stockhq _stockhq = stockhqMapper.selectByCodeAndDate(stockhq);//检查库里是否已有
		if(_stockhq!=null){
			stockhq.setId(_stockhq.getId());
			stockhqMapper.updateByPrimaryKey(stockhq);
			System.out.println("更新:"+stockhq.getHqdate()+" "+stockhq.getStockcode()+" "+stockhq.getStockname());
			MyLog.hqimportLogger.info("更新:"+stockhq.getStockcode()+" "+stockhq.getHqdate()+" "+stockhq.getStockname());
		}else{
			stockhqMapper.insert(stockhq);
			System.out.println("新增:"+stockhq.getHqdate()+" "+stockhq.getStockcode()+" "+stockhq.getStockname());
			MyLog.hqimportLogger.info("新增:"+stockhq.getStockcode()+" "+stockhq.getHqdate()+" "+stockhq.getStockname());
		}
		
		return stockhq;
	}	
	
	
	/*
	 * 查询最近n天的行情
	 */
	public List<Stockhq> queryRecentStockhq(String stockCode, int days) {
		switch (days) {
		case 4:
			return stockhqMapper.queryRecent4Stockhq(stockCode);
		default:
			return null;
		}
	}

}
