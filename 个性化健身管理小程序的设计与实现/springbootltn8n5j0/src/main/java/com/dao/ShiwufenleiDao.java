package com.dao;

import com.entity.ShiwufenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShiwufenleiVO;
import com.entity.view.ShiwufenleiView;


/**
 * 食物分类
 * 
 * @author 
 * @email 
 * @date 2025-04-14 18:26:07
 */
public interface ShiwufenleiDao extends BaseMapper<ShiwufenleiEntity> {
	
	List<ShiwufenleiVO> selectListVO(@Param("ew") Wrapper<ShiwufenleiEntity> wrapper);
	
	ShiwufenleiVO selectVO(@Param("ew") Wrapper<ShiwufenleiEntity> wrapper);
	
	List<ShiwufenleiView> selectListView(@Param("ew") Wrapper<ShiwufenleiEntity> wrapper);

	List<ShiwufenleiView> selectListView(Pagination page,@Param("ew") Wrapper<ShiwufenleiEntity> wrapper);

	
	ShiwufenleiView selectView(@Param("ew") Wrapper<ShiwufenleiEntity> wrapper);
	

}
