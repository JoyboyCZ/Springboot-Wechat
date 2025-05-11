package com.dao;

import com.entity.JianshenzhuanjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JianshenzhuanjiaVO;
import com.entity.view.JianshenzhuanjiaView;


/**
 * 健身专家
 * 
 * @author 
 * @email 
 * @date 2025-04-14 18:26:05
 */
public interface JianshenzhuanjiaDao extends BaseMapper<JianshenzhuanjiaEntity> {
	
	List<JianshenzhuanjiaVO> selectListVO(@Param("ew") Wrapper<JianshenzhuanjiaEntity> wrapper);
	
	JianshenzhuanjiaVO selectVO(@Param("ew") Wrapper<JianshenzhuanjiaEntity> wrapper);
	
	List<JianshenzhuanjiaView> selectListView(@Param("ew") Wrapper<JianshenzhuanjiaEntity> wrapper);

	List<JianshenzhuanjiaView> selectListView(Pagination page,@Param("ew") Wrapper<JianshenzhuanjiaEntity> wrapper);

	
	JianshenzhuanjiaView selectView(@Param("ew") Wrapper<JianshenzhuanjiaEntity> wrapper);
	

}
