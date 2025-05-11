package com.dao;

import com.entity.JianshenjinduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JianshenjinduVO;
import com.entity.view.JianshenjinduView;


/**
 * 健身进度
 * 
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
public interface JianshenjinduDao extends BaseMapper<JianshenjinduEntity> {
	
	List<JianshenjinduVO> selectListVO(@Param("ew") Wrapper<JianshenjinduEntity> wrapper);
	
	JianshenjinduVO selectVO(@Param("ew") Wrapper<JianshenjinduEntity> wrapper);
	
	List<JianshenjinduView> selectListView(@Param("ew") Wrapper<JianshenjinduEntity> wrapper);

	List<JianshenjinduView> selectListView(Pagination page,@Param("ew") Wrapper<JianshenjinduEntity> wrapper);

	
	JianshenjinduView selectView(@Param("ew") Wrapper<JianshenjinduEntity> wrapper);
	

}
