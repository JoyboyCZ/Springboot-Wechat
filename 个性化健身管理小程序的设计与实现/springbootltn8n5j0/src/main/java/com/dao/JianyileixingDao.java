package com.dao;

import com.entity.JianyileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JianyileixingVO;
import com.entity.view.JianyileixingView;


/**
 * 建议类型
 * 
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
public interface JianyileixingDao extends BaseMapper<JianyileixingEntity> {
	
	List<JianyileixingVO> selectListVO(@Param("ew") Wrapper<JianyileixingEntity> wrapper);
	
	JianyileixingVO selectVO(@Param("ew") Wrapper<JianyileixingEntity> wrapper);
	
	List<JianyileixingView> selectListView(@Param("ew") Wrapper<JianyileixingEntity> wrapper);

	List<JianyileixingView> selectListView(Pagination page,@Param("ew") Wrapper<JianyileixingEntity> wrapper);

	
	JianyileixingView selectView(@Param("ew") Wrapper<JianyileixingEntity> wrapper);
	

}
