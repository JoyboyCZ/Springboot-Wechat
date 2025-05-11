package com.dao;

import com.entity.DiscussjianshenjianyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjianshenjianyiVO;
import com.entity.view.DiscussjianshenjianyiView;


/**
 * 健身建议评论表
 * 
 * @author 
 * @email 
 * @date 2025-04-14 18:26:09
 */
public interface DiscussjianshenjianyiDao extends BaseMapper<DiscussjianshenjianyiEntity> {
	
	List<DiscussjianshenjianyiVO> selectListVO(@Param("ew") Wrapper<DiscussjianshenjianyiEntity> wrapper);
	
	DiscussjianshenjianyiVO selectVO(@Param("ew") Wrapper<DiscussjianshenjianyiEntity> wrapper);
	
	List<DiscussjianshenjianyiView> selectListView(@Param("ew") Wrapper<DiscussjianshenjianyiEntity> wrapper);

	List<DiscussjianshenjianyiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjianshenjianyiEntity> wrapper);

	
	DiscussjianshenjianyiView selectView(@Param("ew") Wrapper<DiscussjianshenjianyiEntity> wrapper);
	

}
