package com.entity.view;

import com.entity.DiscussyinshijianyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 饮食建议评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-14 18:26:09
 */
@TableName("discussyinshijianyi")
public class DiscussyinshijianyiView  extends DiscussyinshijianyiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussyinshijianyiView(){
	}
 
 	public DiscussyinshijianyiView(DiscussyinshijianyiEntity discussyinshijianyiEntity){
 	try {
			BeanUtils.copyProperties(this, discussyinshijianyiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
