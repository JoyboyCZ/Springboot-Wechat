package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianyileixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JianyileixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JianyileixingView;


/**
 * 建议类型
 *
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
public interface JianyileixingService extends IService<JianyileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianyileixingVO> selectListVO(Wrapper<JianyileixingEntity> wrapper);
   	
   	JianyileixingVO selectVO(@Param("ew") Wrapper<JianyileixingEntity> wrapper);
   	
   	List<JianyileixingView> selectListView(Wrapper<JianyileixingEntity> wrapper);
   	
   	JianyileixingView selectView(@Param("ew") Wrapper<JianyileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianyileixingEntity> wrapper);

   	

}

