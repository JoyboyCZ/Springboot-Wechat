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
 * 饮食定制
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-14 18:26:07
 */
@TableName("yinshidingzhi")
public class YinshidingzhiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YinshidingzhiEntity() {
		
	}
	
	public YinshidingzhiEntity(T t) {
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
	 * 食物名称
	 */
					
	private String shiwumingcheng;
	
	/**
	 * 食物分类
	 */
					
	private String shiwufenlei;
	
	/**
	 * 食物图片
	 */
					
	private String shiwutupian;
	
	/**
	 * 食物热量
	 */
					
	private String shiwureliang;
	
	/**
	 * 蛋白质
	 */
					
	private String danbaizhi;
	
	/**
	 * 食物脂肪
	 */
					
	private String shiwuzhifang;
	
	/**
	 * 碳水化合物
	 */
					
	private String tanshuihuahewu;
	
	/**
	 * 饮食量
	 */
					
	private String yinshiliang;
	
	/**
	 * 定制时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date dingzhishijian;
	
	/**
	 * 定制详情
	 */
					
	private String dingzhixiangqing;
	
	/**
	 * 营养师账号
	 */
					
	private String yingyangshizhanghao;
	
	/**
	 * 营养师姓名
	 */
					
	private String yingyangshixingming;
	
	
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
	 * 设置：食物名称
	 */
	public void setShiwumingcheng(String shiwumingcheng) {
		this.shiwumingcheng = shiwumingcheng;
	}
	/**
	 * 获取：食物名称
	 */
	public String getShiwumingcheng() {
		return shiwumingcheng;
	}
	/**
	 * 设置：食物分类
	 */
	public void setShiwufenlei(String shiwufenlei) {
		this.shiwufenlei = shiwufenlei;
	}
	/**
	 * 获取：食物分类
	 */
	public String getShiwufenlei() {
		return shiwufenlei;
	}
	/**
	 * 设置：食物图片
	 */
	public void setShiwutupian(String shiwutupian) {
		this.shiwutupian = shiwutupian;
	}
	/**
	 * 获取：食物图片
	 */
	public String getShiwutupian() {
		return shiwutupian;
	}
	/**
	 * 设置：食物热量
	 */
	public void setShiwureliang(String shiwureliang) {
		this.shiwureliang = shiwureliang;
	}
	/**
	 * 获取：食物热量
	 */
	public String getShiwureliang() {
		return shiwureliang;
	}
	/**
	 * 设置：蛋白质
	 */
	public void setDanbaizhi(String danbaizhi) {
		this.danbaizhi = danbaizhi;
	}
	/**
	 * 获取：蛋白质
	 */
	public String getDanbaizhi() {
		return danbaizhi;
	}
	/**
	 * 设置：食物脂肪
	 */
	public void setShiwuzhifang(String shiwuzhifang) {
		this.shiwuzhifang = shiwuzhifang;
	}
	/**
	 * 获取：食物脂肪
	 */
	public String getShiwuzhifang() {
		return shiwuzhifang;
	}
	/**
	 * 设置：碳水化合物
	 */
	public void setTanshuihuahewu(String tanshuihuahewu) {
		this.tanshuihuahewu = tanshuihuahewu;
	}
	/**
	 * 获取：碳水化合物
	 */
	public String getTanshuihuahewu() {
		return tanshuihuahewu;
	}
	/**
	 * 设置：饮食量
	 */
	public void setYinshiliang(String yinshiliang) {
		this.yinshiliang = yinshiliang;
	}
	/**
	 * 获取：饮食量
	 */
	public String getYinshiliang() {
		return yinshiliang;
	}
	/**
	 * 设置：定制时间
	 */
	public void setDingzhishijian(Date dingzhishijian) {
		this.dingzhishijian = dingzhishijian;
	}
	/**
	 * 获取：定制时间
	 */
	public Date getDingzhishijian() {
		return dingzhishijian;
	}
	/**
	 * 设置：定制详情
	 */
	public void setDingzhixiangqing(String dingzhixiangqing) {
		this.dingzhixiangqing = dingzhixiangqing;
	}
	/**
	 * 获取：定制详情
	 */
	public String getDingzhixiangqing() {
		return dingzhixiangqing;
	}
	/**
	 * 设置：营养师账号
	 */
	public void setYingyangshizhanghao(String yingyangshizhanghao) {
		this.yingyangshizhanghao = yingyangshizhanghao;
	}
	/**
	 * 获取：营养师账号
	 */
	public String getYingyangshizhanghao() {
		return yingyangshizhanghao;
	}
	/**
	 * 设置：营养师姓名
	 */
	public void setYingyangshixingming(String yingyangshixingming) {
		this.yingyangshixingming = yingyangshixingming;
	}
	/**
	 * 获取：营养师姓名
	 */
	public String getYingyangshixingming() {
		return yingyangshixingming;
	}

}
