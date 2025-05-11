package com.dao;

import com.entity.YingyangzhuanjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YingyangzhuanjiaVO;
import com.entity.view.YingyangzhuanjiaView;


/**
 * 营养专家
 * 
 * @author 
 * @email 
 * @date 2025-04-14 18:26:05
 */
public interface YingyangzhuanjiaDao extends BaseMapper<YingyangzhuanjiaEntity> {
	
	List<YingyangzhuanjiaVO> selectListVO(@Param("ew") Wrapper<YingyangzhuanjiaEntity> wrapper);
	
	YingyangzhuanjiaVO selectVO(@Param("ew") Wrapper<YingyangzhuanjiaEntity> wrapper);
	
	List<YingyangzhuanjiaView> selectListView(@Param("ew") Wrapper<YingyangzhuanjiaEntity> wrapper);

	List<YingyangzhuanjiaView> selectListView(Pagination page,@Param("ew") Wrapper<YingyangzhuanjiaEntity> wrapper);

	
	YingyangzhuanjiaView selectView(@Param("ew") Wrapper<YingyangzhuanjiaEntity> wrapper);
	

}
