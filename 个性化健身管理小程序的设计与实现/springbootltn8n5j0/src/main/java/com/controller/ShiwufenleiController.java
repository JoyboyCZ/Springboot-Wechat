package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShiwufenleiEntity;
import com.entity.view.ShiwufenleiView;

import com.service.ShiwufenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 食物分类
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-14 18:26:07
 */
@RestController
@RequestMapping("/shiwufenlei")
public class ShiwufenleiController {
    @Autowired
    private ShiwufenleiService shiwufenleiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShiwufenleiEntity shiwufenlei,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShiwufenleiEntity> ew = new EntityWrapper<ShiwufenleiEntity>();


        //查询结果
		PageUtils page = shiwufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiwufenlei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShiwufenleiEntity shiwufenlei, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShiwufenleiEntity> ew = new EntityWrapper<ShiwufenleiEntity>();

        //查询结果
		PageUtils page = shiwufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiwufenlei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShiwufenleiEntity shiwufenlei){
       	EntityWrapper<ShiwufenleiEntity> ew = new EntityWrapper<ShiwufenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shiwufenlei, "shiwufenlei")); 
        return R.ok().put("data", shiwufenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShiwufenleiEntity shiwufenlei){
        EntityWrapper< ShiwufenleiEntity> ew = new EntityWrapper< ShiwufenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shiwufenlei, "shiwufenlei")); 
		ShiwufenleiView shiwufenleiView =  shiwufenleiService.selectView(ew);
		return R.ok("查询食物分类成功").put("data", shiwufenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShiwufenleiEntity shiwufenlei = shiwufenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shiwufenlei,deSens);
        return R.ok().put("data", shiwufenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShiwufenleiEntity shiwufenlei = shiwufenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shiwufenlei,deSens);
        return R.ok().put("data", shiwufenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShiwufenleiEntity shiwufenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(shiwufenleiService.selectCount(new EntityWrapper<ShiwufenleiEntity>().eq("shiwufenlei", shiwufenlei.getShiwufenlei()))>0) {
            return R.error("食物分类已存在");
        }
        //ValidatorUtils.validateEntity(shiwufenlei);
        shiwufenleiService.insert(shiwufenlei);
        return R.ok().put("data",shiwufenlei.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShiwufenleiEntity shiwufenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(shiwufenleiService.selectCount(new EntityWrapper<ShiwufenleiEntity>().eq("shiwufenlei", shiwufenlei.getShiwufenlei()))>0) {
            return R.error("食物分类已存在");
        }
        //ValidatorUtils.validateEntity(shiwufenlei);
        shiwufenleiService.insert(shiwufenlei);
        return R.ok().put("data",shiwufenlei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShiwufenleiEntity shiwufenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shiwufenlei);
        //验证字段唯一性，否则返回错误信息
        if(shiwufenleiService.selectCount(new EntityWrapper<ShiwufenleiEntity>().ne("id", shiwufenlei.getId()).eq("shiwufenlei", shiwufenlei.getShiwufenlei()))>0) {
            return R.error("食物分类已存在");
        }
        //全部更新
        shiwufenleiService.updateById(shiwufenlei);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shiwufenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
