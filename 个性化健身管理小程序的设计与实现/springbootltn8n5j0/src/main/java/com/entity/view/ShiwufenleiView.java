package com.entity.view;

import com.entity.ShiwufenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 食物分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-14 18:26:07
 */
@TableName("shiwufenlei")
public class ShiwufenleiView  extends ShiwufenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShiwufenleiView(){
	}
 
 	public ShiwufenleiView(ShiwufenleiEntity shiwufenleiEntity){
 	try {
			BeanUtils.copyProperties(this, shiwufenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
