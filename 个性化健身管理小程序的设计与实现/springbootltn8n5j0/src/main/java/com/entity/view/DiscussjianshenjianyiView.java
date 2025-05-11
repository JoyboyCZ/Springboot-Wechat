package com.entity.view;

import com.entity.DiscussjianshenjianyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 健身建议评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-14 18:26:09
 */
@TableName("discussjianshenjianyi")
public class DiscussjianshenjianyiView  extends DiscussjianshenjianyiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussjianshenjianyiView(){
	}
 
 	public DiscussjianshenjianyiView(DiscussjianshenjianyiEntity discussjianshenjianyiEntity){
 	try {
			BeanUtils.copyProperties(this, discussjianshenjianyiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
