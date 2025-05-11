package com.entity.view;

import com.entity.JianyileixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 建议类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
@TableName("jianyileixing")
public class JianyileixingView  extends JianyileixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JianyileixingView(){
	}
 
 	public JianyileixingView(JianyileixingEntity jianyileixingEntity){
 	try {
			BeanUtils.copyProperties(this, jianyileixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
