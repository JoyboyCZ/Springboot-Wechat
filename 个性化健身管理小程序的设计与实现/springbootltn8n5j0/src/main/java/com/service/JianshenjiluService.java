package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianshenjiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JianshenjiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JianshenjiluView;


/**
 * 健身记录
 *
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
public interface JianshenjiluService extends IService<JianshenjiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianshenjiluVO> selectListVO(Wrapper<JianshenjiluEntity> wrapper);
   	
   	JianshenjiluVO selectVO(@Param("ew") Wrapper<JianshenjiluEntity> wrapper);
   	
   	List<JianshenjiluView> selectListView(Wrapper<JianshenjiluEntity> wrapper);
   	
   	JianshenjiluView selectView(@Param("ew") Wrapper<JianshenjiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianshenjiluEntity> wrapper);

   	

}

