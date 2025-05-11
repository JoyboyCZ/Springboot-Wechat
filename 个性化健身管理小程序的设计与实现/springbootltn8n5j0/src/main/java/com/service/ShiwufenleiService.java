package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShiwufenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShiwufenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShiwufenleiView;


/**
 * 食物分类
 *
 * @author 
 * @email 
 * @date 2025-04-14 18:26:07
 */
public interface ShiwufenleiService extends IService<ShiwufenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShiwufenleiVO> selectListVO(Wrapper<ShiwufenleiEntity> wrapper);
   	
   	ShiwufenleiVO selectVO(@Param("ew") Wrapper<ShiwufenleiEntity> wrapper);
   	
   	List<ShiwufenleiView> selectListView(Wrapper<ShiwufenleiEntity> wrapper);
   	
   	ShiwufenleiView selectView(@Param("ew") Wrapper<ShiwufenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShiwufenleiEntity> wrapper);

   	

}

