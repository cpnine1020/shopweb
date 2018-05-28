package com.xiangxiaole.www.dao;

import java.util.List;

import com.xiangxiaole.util.page.Page;
import com.xiangxiaole.www.model.News;

public interface NewsMapper {
	
	List<News> selectByPage(Page<News> page);//根据条件查询
	News selectLast(News record);//上一篇（同来源的）
	News selectNext(News record);//下一篇（同来源的）
	
	
	
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);
}