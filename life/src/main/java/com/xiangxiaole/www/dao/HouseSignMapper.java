package com.xiangxiaole.www.dao;

import java.util.List;

import com.xiangxiaole.www.model.HouseSign;

public interface HouseSignMapper {
	
	
	HouseSign selectBySignDateAndCity(HouseSign record);// 根据签约日期和城市查询
	List<HouseSign> queryRecentHouseSign();//查询最近的365条存量房签约记录
	
	
	
    int deleteByPrimaryKey(Integer id);

    int insert(HouseSign record);

    int insertSelective(HouseSign record);

    HouseSign selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseSign record);

    int updateByPrimaryKey(HouseSign record);
}