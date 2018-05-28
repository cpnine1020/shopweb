package com.ningx.stock.dao;

import java.util.List;

import com.ningx.stock.model.Stockhq;

public interface StockhqMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Stockhq record);

    int insertSelective(Stockhq record);

    Stockhq selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Stockhq record);

    int updateByPrimaryKey(Stockhq record);
    
    Stockhq selectByCodeAndDate(Stockhq record);
    
    /*查询最近4天的行情*/
    List<Stockhq> queryRecent4Stockhq(String stockCode);
}