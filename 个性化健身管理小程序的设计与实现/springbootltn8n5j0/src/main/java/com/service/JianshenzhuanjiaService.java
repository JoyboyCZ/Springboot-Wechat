package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianshenzhuanjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JianshenzhuanjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JianshenzhuanjiaView;


/**
 * 健身专家
 *
 * @author 
 * @email 
 * @date 2025-04-14 18:26:05
 */
public interface JianshenzhuanjiaService extends IService<JianshenzhuanjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianshenzhuanjiaVO> selectListVO(Wrapper<JianshenzhuanjiaEntity> wrapper);
   	
   	JianshenzhuanjiaVO selectVO(@Param("ew") Wrapper<JianshenzhuanjiaEntity> wrapper);
   	
   	List<JianshenzhuanjiaView> selectListView(Wrapper<JianshenzhuanjiaEntity> wrapper);
   	
   	JianshenzhuanjiaView selectView(@Param("ew") Wrapper<JianshenzhuanjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianshenzhuanjiaEntity> wrapper);

   	

}

