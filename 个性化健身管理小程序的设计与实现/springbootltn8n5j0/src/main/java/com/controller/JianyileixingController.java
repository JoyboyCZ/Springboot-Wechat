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

import com.entity.JianyileixingEntity;
import com.entity.view.JianyileixingView;

import com.service.JianyileixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 建议类型
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
@RestController
@RequestMapping("/jianyileixing")
public class JianyileixingController {
    @Autowired
    private JianyileixingService jianyileixingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianyileixingEntity jianyileixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JianyileixingEntity> ew = new EntityWrapper<JianyileixingEntity>();


        //查询结果
		PageUtils page = jianyileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianyileixing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JianyileixingEntity jianyileixing, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JianyileixingEntity> ew = new EntityWrapper<JianyileixingEntity>();

        //查询结果
		PageUtils page = jianyileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianyileixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianyileixingEntity jianyileixing){
       	EntityWrapper<JianyileixingEntity> ew = new EntityWrapper<JianyileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianyileixing, "jianyileixing")); 
        return R.ok().put("data", jianyileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianyileixingEntity jianyileixing){
        EntityWrapper< JianyileixingEntity> ew = new EntityWrapper< JianyileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianyileixing, "jianyileixing")); 
		JianyileixingView jianyileixingView =  jianyileixingService.selectView(ew);
		return R.ok("查询建议类型成功").put("data", jianyileixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianyileixingEntity jianyileixing = jianyileixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jianyileixing,deSens);
        return R.ok().put("data", jianyileixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianyileixingEntity jianyileixing = jianyileixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jianyileixing,deSens);
        return R.ok().put("data", jianyileixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianyileixingEntity jianyileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianyileixing);
        jianyileixingService.insert(jianyileixing);
        return R.ok().put("data",jianyileixing.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianyileixingEntity jianyileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianyileixing);
        jianyileixingService.insert(jianyileixing);
        return R.ok().put("data",jianyileixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianyileixingEntity jianyileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianyileixing);
        //全部更新
        jianyileixingService.updateById(jianyileixing);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianyileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
