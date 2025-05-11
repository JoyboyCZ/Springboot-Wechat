package com.entity.view;

import com.entity.JianshendingzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 健身定制
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
@TableName("jianshendingzhi")
public class JianshendingzhiView  extends JianshendingzhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JianshendingzhiView(){
	}
 
 	public JianshendingzhiView(JianshendingzhiEntity jianshendingzhiEntity){
 	try {
			BeanUtils.copyProperties(this, jianshendingzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
