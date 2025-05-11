package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianshendingzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JianshendingzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JianshendingzhiView;


/**
 * 健身定制
 *
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
public interface JianshendingzhiService extends IService<JianshendingzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianshendingzhiVO> selectListVO(Wrapper<JianshendingzhiEntity> wrapper);
   	
   	JianshendingzhiVO selectVO(@Param("ew") Wrapper<JianshendingzhiEntity> wrapper);
   	
   	List<JianshendingzhiView> selectListView(Wrapper<JianshendingzhiEntity> wrapper);
   	
   	JianshendingzhiView selectView(@Param("ew") Wrapper<JianshendingzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianshendingzhiEntity> wrapper);

   	

}

