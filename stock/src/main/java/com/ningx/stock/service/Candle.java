package com.ningx.stock.service;

import java.util.List;

import com.ningx.stock.model.Stockhq;
import com.ningx.stock.util.data.Constant;

/**
 * 蜡烛图形态
 * @author Administrator
 *
 */
public class Candle {
	
	/**
	 * 锤子线
	 */
	public static boolean isChuiZiXian(List<Stockhq> list){
		//下跌趋势t3.xj>t2.xj>t1.xj>t0.xj  
		if(CandleTool.trend(list, Constant.TREND_LOW, 3)){
		}else{
			return false;
		}
		//|t0.kp-t0.xj|*2<=min(t0.kp,t0.xj)-t0.low 
		if(Math.abs(list.get(0).getXj()-list.get(0).getJrkp())*2<=(Math.min(list.get(0).getXj(), list.get(0).getJrkp())-list.get(0).getLow())){		
		}else{
			return false;
		}
		//(t0.high- max(t0.kp,t0.xj))*5< |t0.kp-t0.xj|
		if((list.get(0).getHigh()-Math.max(list.get(0).getXj(), list.get(0).getJrkp()))*5<Math.abs(list.get(0).getJrkp()-list.get(0).getXj())){	
		}else{
			return false;
		}
		return true;
	}
}
