package com.dao;

import com.entity.YinshijianyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YinshijianyiVO;
import com.entity.view.YinshijianyiView;


/**
 * 饮食建议
 * 
 * @author 
 * @email 
 * @date 2025-04-14 18:26:07
 */
public interface YinshijianyiDao extends BaseMapper<YinshijianyiEntity> {
	
	List<YinshijianyiVO> selectListVO(@Param("ew") Wrapper<YinshijianyiEntity> wrapper);
	
	YinshijianyiVO selectVO(@Param("ew") Wrapper<YinshijianyiEntity> wrapper);
	
	List<YinshijianyiView> selectListView(@Param("ew") Wrapper<YinshijianyiEntity> wrapper);

	List<YinshijianyiView> selectListView(Pagination page,@Param("ew") Wrapper<YinshijianyiEntity> wrapper);

	
	YinshijianyiView selectView(@Param("ew") Wrapper<YinshijianyiEntity> wrapper);
	

}
