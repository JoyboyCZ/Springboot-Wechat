package com.entity.vo;

import com.entity.JianshenjinduEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 健身进度
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
public class JianshenjinduVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	 * 训练时长
	 */
	
	private String xunlianshizhang;
		
	/**
	 * 天数
	 */
	
	private String tianshu;
		
	/**
	 * 训练状态
	 */
	
	private String xunlianzhuangtai;
		
	/**
	 * 训练时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date xunlianshijian;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
				
	
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
	 * 设置：训练时长
	 */
	 
	public void setXunlianshizhang(String xunlianshizhang) {
		this.xunlianshizhang = xunlianshizhang;
	}
	
	/**
	 * 获取：训练时长
	 */
	public String getXunlianshizhang() {
		return xunlianshizhang;
	}
				
	
	/**
	 * 设置：天数
	 */
	 
	public void setTianshu(String tianshu) {
		this.tianshu = tianshu;
	}
	
	/**
	 * 获取：天数
	 */
	public String getTianshu() {
		return tianshu;
	}
				
	
	/**
	 * 设置：训练状态
	 */
	 
	public void setXunlianzhuangtai(String xunlianzhuangtai) {
		this.xunlianzhuangtai = xunlianzhuangtai;
	}
	
	/**
	 * 获取：训练状态
	 */
	public String getXunlianzhuangtai() {
		return xunlianzhuangtai;
	}
				
	
	/**
	 * 设置：训练时间
	 */
	 
	public void setXunlianshijian(Date xunlianshijian) {
		this.xunlianshijian = xunlianshijian;
	}
	
	/**
	 * 获取：训练时间
	 */
	public Date getXunlianshijian() {
		return xunlianshijian;
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
			
}
