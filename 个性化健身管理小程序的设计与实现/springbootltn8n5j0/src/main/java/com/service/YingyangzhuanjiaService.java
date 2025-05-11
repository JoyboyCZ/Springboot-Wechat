package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YingyangzhuanjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YingyangzhuanjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YingyangzhuanjiaView;


/**
 * 营养专家
 *
 * @author 
 * @email 
 * @date 2025-04-14 18:26:05
 */
public interface YingyangzhuanjiaService extends IService<YingyangzhuanjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YingyangzhuanjiaVO> selectListVO(Wrapper<YingyangzhuanjiaEntity> wrapper);
   	
   	YingyangzhuanjiaVO selectVO(@Param("ew") Wrapper<YingyangzhuanjiaEntity> wrapper);
   	
   	List<YingyangzhuanjiaView> selectListView(Wrapper<YingyangzhuanjiaEntity> wrapper);
   	
   	YingyangzhuanjiaView selectView(@Param("ew") Wrapper<YingyangzhuanjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YingyangzhuanjiaEntity> wrapper);

   	

}

