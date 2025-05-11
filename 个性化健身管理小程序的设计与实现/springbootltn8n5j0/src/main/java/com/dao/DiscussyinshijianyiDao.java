package com.dao;

import com.entity.DiscussyinshijianyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyinshijianyiVO;
import com.entity.view.DiscussyinshijianyiView;


/**
 * 饮食建议评论表
 * 
 * @author 
 * @email 
 * @date 2025-04-14 18:26:09
 */
public interface DiscussyinshijianyiDao extends BaseMapper<DiscussyinshijianyiEntity> {
	
	List<DiscussyinshijianyiVO> selectListVO(@Param("ew") Wrapper<DiscussyinshijianyiEntity> wrapper);
	
	DiscussyinshijianyiVO selectVO(@Param("ew") Wrapper<DiscussyinshijianyiEntity> wrapper);
	
	List<DiscussyinshijianyiView> selectListView(@Param("ew") Wrapper<DiscussyinshijianyiEntity> wrapper);

	List<DiscussyinshijianyiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyinshijianyiEntity> wrapper);

	
	DiscussyinshijianyiView selectView(@Param("ew") Wrapper<DiscussyinshijianyiEntity> wrapper);
	

}
