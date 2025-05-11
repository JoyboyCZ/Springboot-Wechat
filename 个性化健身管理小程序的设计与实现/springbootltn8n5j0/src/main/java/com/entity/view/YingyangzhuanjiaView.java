package com.entity.view;

import com.entity.YingyangzhuanjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 营养专家
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-14 18:26:05
 */
@TableName("yingyangzhuanjia")
public class YingyangzhuanjiaView  extends YingyangzhuanjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YingyangzhuanjiaView(){
	}
 
 	public YingyangzhuanjiaView(YingyangzhuanjiaEntity yingyangzhuanjiaEntity){
 	try {
			BeanUtils.copyProperties(this, yingyangzhuanjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
