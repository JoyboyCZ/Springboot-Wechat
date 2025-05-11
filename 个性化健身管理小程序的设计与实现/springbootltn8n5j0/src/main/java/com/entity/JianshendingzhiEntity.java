package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 健身定制
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
@TableName("jianshendingzhi")
public class JianshendingzhiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JianshendingzhiEntity() {
		
	}
	
	public JianshendingzhiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 计划标题
	 */
					
	private String jihuabiaoti;
	
	/**
	 * 运动类型
	 */
					
	private String yundongleixing;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 训练方式
	 */
					
	private String xunlianfangshi;
	
	/**
	 * 训练频率
	 */
					
	private String xunlianpinlv;
	
	/**
	 * 预期目标
	 */
					
	private String yuqimubiao;
	
	/**
	 * 训练天数
	 */
					
	private String xunliantianshu;
	
	/**
	 * 计划详情
	 */
					
	private String jihuaxiangqing;
	
	/**
	 * 计划时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date jihuashijian;
	
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：计划标题
	 */
	public void setJihuabiaoti(String jihuabiaoti) {
		this.jihuabiaoti = jihuabiaoti;
	}
	/**
	 * 获取：计划标题
	 */
	public String getJihuabiaoti() {
		return jihuabiaoti;
	}
	/**
	 * 设置：运动类型
	 */
	public void setYundongleixing(String yundongleixing) {
		this.yundongleixing = yundongleixing;
	}
	/**
	 * 获取：运动类型
	 */
	public String getYundongleixing() {
		return yundongleixing;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：训练方式
	 */
	public void setXunlianfangshi(String xunlianfangshi) {
		this.xunlianfangshi = xunlianfangshi;
	}
	/**
	 * 获取：训练方式
	 */
	public String getXunlianfangshi() {
		return xunlianfangshi;
	}
	/**
	 * 设置：训练频率
	 */
	public void setXunlianpinlv(String xunlianpinlv) {
		this.xunlianpinlv = xunlianpinlv;
	}
	/**
	 * 获取：训练频率
	 */
	public String getXunlianpinlv() {
		return xunlianpinlv;
	}
	/**
	 * 设置：预期目标
	 */
	public void setYuqimubiao(String yuqimubiao) {
		this.yuqimubiao = yuqimubiao;
	}
	/**
	 * 获取：预期目标
	 */
	public String getYuqimubiao() {
		return yuqimubiao;
	}
	/**
	 * 设置：训练天数
	 */
	public void setXunliantianshu(String xunliantianshu) {
		this.xunliantianshu = xunliantianshu;
	}
	/**
	 * 获取：训练天数
	 */
	public String getXunliantianshu() {
		return xunliantianshu;
	}
	/**
	 * 设置：计划详情
	 */
	public void setJihuaxiangqing(String jihuaxiangqing) {
		this.jihuaxiangqing = jihuaxiangqing;
	}
	/**
	 * 获取：计划详情
	 */
	public String getJihuaxiangqing() {
		return jihuaxiangqing;
	}
	/**
	 * 设置：计划时间
	 */
	public void setJihuashijian(Date jihuashijian) {
		this.jihuashijian = jihuashijian;
	}
	/**
	 * 获取：计划时间
	 */
	public Date getJihuashijian() {
		return jihuashijian;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
