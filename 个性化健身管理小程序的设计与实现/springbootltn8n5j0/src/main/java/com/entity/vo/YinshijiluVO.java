package com.entity.vo;

import com.entity.YinshijiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 饮食记录
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
public class YinshijiluVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 标题
	 */
	
	private String biaoti;
		
	/**
	 * 日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date riqi;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 早餐摄入
	 */
	
	private Integer zaocansheru;
		
	/**
	 * 中餐摄入
	 */
	
	private Integer zhongcansheru;
		
	/**
	 * 晚餐摄入
	 */
	
	private Integer wancansheru;
		
	/**
	 * 加餐摄入
	 */
	
	private Integer jiacansheru;
		
	/**
	 * 摄入总热量
	 */
	
	private Integer sheruzongreliang;
		
	/**
	 * 登记时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjishijian;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
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
	 * 设置：标题
	 */
	 
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	
	/**
	 * 获取：标题
	 */
	public String getBiaoti() {
		return biaoti;
	}
				
	
	/**
	 * 设置：日期
	 */
	 
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	
	/**
	 * 获取：日期
	 */
	public Date getRiqi() {
		return riqi;
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
	 * 设置：早餐摄入
	 */
	 
	public void setZaocansheru(Integer zaocansheru) {
		this.zaocansheru = zaocansheru;
	}
	
	/**
	 * 获取：早餐摄入
	 */
	public Integer getZaocansheru() {
		return zaocansheru;
	}
				
	
	/**
	 * 设置：中餐摄入
	 */
	 
	public void setZhongcansheru(Integer zhongcansheru) {
		this.zhongcansheru = zhongcansheru;
	}
	
	/**
	 * 获取：中餐摄入
	 */
	public Integer getZhongcansheru() {
		return zhongcansheru;
	}
				
	
	/**
	 * 设置：晚餐摄入
	 */
	 
	public void setWancansheru(Integer wancansheru) {
		this.wancansheru = wancansheru;
	}
	
	/**
	 * 获取：晚餐摄入
	 */
	public Integer getWancansheru() {
		return wancansheru;
	}
				
	
	/**
	 * 设置：加餐摄入
	 */
	 
	public void setJiacansheru(Integer jiacansheru) {
		this.jiacansheru = jiacansheru;
	}
	
	/**
	 * 获取：加餐摄入
	 */
	public Integer getJiacansheru() {
		return jiacansheru;
	}
				
	
	/**
	 * 设置：摄入总热量
	 */
	 
	public void setSheruzongreliang(Integer sheruzongreliang) {
		this.sheruzongreliang = sheruzongreliang;
	}
	
	/**
	 * 获取：摄入总热量
	 */
	public Integer getSheruzongreliang() {
		return sheruzongreliang;
	}
				
	
	/**
	 * 设置：登记时间
	 */
	 
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
