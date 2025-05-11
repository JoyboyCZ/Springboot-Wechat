package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjianshenjianyiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjianshenjianyiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjianshenjianyiView;


/**
 * 健身建议评论表
 *
 * @author 
 * @email 
 * @date 2025-04-14 18:26:09
 */
public interface DiscussjianshenjianyiService extends IService<DiscussjianshenjianyiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjianshenjianyiVO> selectListVO(Wrapper<DiscussjianshenjianyiEntity> wrapper);
   	
   	DiscussjianshenjianyiVO selectVO(@Param("ew") Wrapper<DiscussjianshenjianyiEntity> wrapper);
   	
   	List<DiscussjianshenjianyiView> selectListView(Wrapper<DiscussjianshenjianyiEntity> wrapper);
   	
   	DiscussjianshenjianyiView selectView(@Param("ew") Wrapper<DiscussjianshenjianyiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjianshenjianyiEntity> wrapper);

   	

}

