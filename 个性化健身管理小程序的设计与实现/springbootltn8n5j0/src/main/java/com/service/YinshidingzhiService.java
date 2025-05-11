package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YinshidingzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YinshidingzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YinshidingzhiView;


/**
 * 饮食定制
 *
 * @author 
 * @email 
 * @date 2025-04-14 18:26:07
 */
public interface YinshidingzhiService extends IService<YinshidingzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinshidingzhiVO> selectListVO(Wrapper<YinshidingzhiEntity> wrapper);
   	
   	YinshidingzhiVO selectVO(@Param("ew") Wrapper<YinshidingzhiEntity> wrapper);
   	
   	List<YinshidingzhiView> selectListView(Wrapper<YinshidingzhiEntity> wrapper);
   	
   	YinshidingzhiView selectView(@Param("ew") Wrapper<YinshidingzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinshidingzhiEntity> wrapper);

   	

}

