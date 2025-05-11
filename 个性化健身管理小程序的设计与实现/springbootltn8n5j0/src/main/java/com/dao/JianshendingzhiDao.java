package com.dao;

import com.entity.JianshendingzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JianshendingzhiVO;
import com.entity.view.JianshendingzhiView;


/**
 * 健身定制
 * 
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
public interface JianshendingzhiDao extends BaseMapper<JianshendingzhiEntity> {
	
	List<JianshendingzhiVO> selectListVO(@Param("ew") Wrapper<JianshendingzhiEntity> wrapper);
	
	JianshendingzhiVO selectVO(@Param("ew") Wrapper<JianshendingzhiEntity> wrapper);
	
	List<JianshendingzhiView> selectListView(@Param("ew") Wrapper<JianshendingzhiEntity> wrapper);

	List<JianshendingzhiView> selectListView(Pagination page,@Param("ew") Wrapper<JianshendingzhiEntity> wrapper);

	
	JianshendingzhiView selectView(@Param("ew") Wrapper<JianshendingzhiEntity> wrapper);
	

}
