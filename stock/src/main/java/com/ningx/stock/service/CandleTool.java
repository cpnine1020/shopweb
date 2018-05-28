package com.ningx.stock.service;

import java.util.List;

import com.ningx.stock.model.Stockhq;
import com.ningx.stock.util.data.Constant;

/**
 * 蜡烛图的常用计算方法
 * @author Administrator
 *
 */
public class CandleTool {

	/**
	 * 趋势
	 * @param flag  -1下跌趋势   1上涨趋势
	 * @param days  持续天数
	 * @return
	 */
	public static boolean trend(List<Stockhq> list,int flag,int days){
		
		if(list.size()<days+1){
			return false;
		}
		
		if(flag==Constant.TREND_LOW){
			for(int i=0;i<days;i++){
				if(list.get(i).getXj()>=list.get(i+1).getXj()){
					return false;
				}
			}
		}else if(flag==Constant.TREND_HIGH){
			for(int i=0;i<days;i++){
				if(list.get(i).getXj()<=list.get(i+1).getXj()){
					return false;
				}
			}
		}
		return true;
	}
}
