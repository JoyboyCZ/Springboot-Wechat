package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianshenjinduEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JianshenjinduVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JianshenjinduView;


/**
 * 健身进度
 *
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
public interface JianshenjinduService extends IService<JianshenjinduEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianshenjinduVO> selectListVO(Wrapper<JianshenjinduEntity> wrapper);
   	
   	JianshenjinduVO selectVO(@Param("ew") Wrapper<JianshenjinduEntity> wrapper);
   	
   	List<JianshenjinduView> selectListView(Wrapper<JianshenjinduEntity> wrapper);
   	
   	JianshenjinduView selectView(@Param("ew") Wrapper<JianshenjinduEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianshenjinduEntity> wrapper);

   	

}

