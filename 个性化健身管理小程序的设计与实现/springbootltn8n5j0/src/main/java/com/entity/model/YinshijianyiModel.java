package com.entity.model;

import com.entity.YinshijianyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 饮食建议
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-14 18:26:07
 */
public class YinshijianyiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 建议类型
	 */
	
	private String jianyileixing;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 营养分析
	 */
	
	private String yingyangfenxi;
		
	/**
	 * 内容
	 */
	
	private String neirong;
		
	/**
	 * 注意事项
	 */
	
	private String zhuyishixiang;
		
	/**
	 * 发布日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date faburiqi;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
		
	/**
	 * 营养师账号
	 */
	
	private String yingyangshizhanghao;
		
	/**
	 * 营养师姓名
	 */
	
	private String yingyangshixingming;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：建议类型
	 */
	 
	public void setJianyileixing(String jianyileixing) {
		this.jianyileixing = jianyileixing;
	}
	
	/**
	 * 获取：建议类型
	 */
	public String getJianyileixing() {
		return jianyileixing;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：营养分析
	 */
	 
	public void setYingyangfenxi(String yingyangfenxi) {
		this.yingyangfenxi = yingyangfenxi;
	}
	
	/**
	 * 获取：营养分析
	 */
	public String getYingyangfenxi() {
		return yingyangfenxi;
	}
				
	
	/**
	 * 设置：内容
	 */
	 
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	
	/**
	 * 获取：内容
	 */
	public String getNeirong() {
		return neirong;
	}
				
	
	/**
	 * 设置：注意事项
	 */
	 
	public void setZhuyishixiang(String zhuyishixiang) {
		this.zhuyishixiang = zhuyishixiang;
	}
	
	/**
	 * 获取：注意事项
	 */
	public String getZhuyishixiang() {
		return zhuyishixiang;
	}
				
	
	/**
	 * 设置：发布日期
	 */
	 
	public void setFaburiqi(Date faburiqi) {
		this.faburiqi = faburiqi;
	}
	
	/**
	 * 获取：发布日期
	 */
	public Date getFaburiqi() {
		return faburiqi;
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
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
