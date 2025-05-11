package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YinshijianyiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YinshijianyiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YinshijianyiView;


/**
 * 饮食建议
 *
 * @author 
 * @email 
 * @date 2025-04-14 18:26:07
 */
public interface YinshijianyiService extends IService<YinshijianyiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinshijianyiVO> selectListVO(Wrapper<YinshijianyiEntity> wrapper);
   	
   	YinshijianyiVO selectVO(@Param("ew") Wrapper<YinshijianyiEntity> wrapper);
   	
   	List<YinshijianyiView> selectListView(Wrapper<YinshijianyiEntity> wrapper);
   	
   	YinshijianyiView selectView(@Param("ew") Wrapper<YinshijianyiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinshijianyiEntity> wrapper);

   	

}

