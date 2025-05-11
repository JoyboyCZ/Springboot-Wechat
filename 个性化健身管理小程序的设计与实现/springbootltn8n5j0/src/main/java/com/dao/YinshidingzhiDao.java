package com.dao;

import com.entity.YinshidingzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YinshidingzhiVO;
import com.entity.view.YinshidingzhiView;


/**
 * 饮食定制
 * 
 * @author 
 * @email 
 * @date 2025-04-14 18:26:07
 */
public interface YinshidingzhiDao extends BaseMapper<YinshidingzhiEntity> {
	
	List<YinshidingzhiVO> selectListVO(@Param("ew") Wrapper<YinshidingzhiEntity> wrapper);
	
	YinshidingzhiVO selectVO(@Param("ew") Wrapper<YinshidingzhiEntity> wrapper);
	
	List<YinshidingzhiView> selectListView(@Param("ew") Wrapper<YinshidingzhiEntity> wrapper);

	List<YinshidingzhiView> selectListView(Pagination page,@Param("ew") Wrapper<YinshidingzhiEntity> wrapper);

	
	YinshidingzhiView selectView(@Param("ew") Wrapper<YinshidingzhiEntity> wrapper);
	

}
