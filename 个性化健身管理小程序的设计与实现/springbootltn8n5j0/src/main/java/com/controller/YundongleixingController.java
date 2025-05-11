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

import com.entity.YundongleixingEntity;
import com.entity.view.YundongleixingView;

import com.service.YundongleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 运动类型
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
@RestController
@RequestMapping("/yundongleixing")
public class YundongleixingController {
    @Autowired
    private YundongleixingService yundongleixingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YundongleixingEntity yundongleixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YundongleixingEntity> ew = new EntityWrapper<YundongleixingEntity>();


        //查询结果
		PageUtils page = yundongleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yundongleixing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YundongleixingEntity yundongleixing, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YundongleixingEntity> ew = new EntityWrapper<YundongleixingEntity>();

        //查询结果
		PageUtils page = yundongleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yundongleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YundongleixingEntity yundongleixing){
       	EntityWrapper<YundongleixingEntity> ew = new EntityWrapper<YundongleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yundongleixing, "yundongleixing")); 
        return R.ok().put("data", yundongleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YundongleixingEntity yundongleixing){
        EntityWrapper< YundongleixingEntity> ew = new EntityWrapper< YundongleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yundongleixing, "yundongleixing")); 
		YundongleixingView yundongleixingView =  yundongleixingService.selectView(ew);
		return R.ok("查询运动类型成功").put("data", yundongleixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YundongleixingEntity yundongleixing = yundongleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yundongleixing,deSens);
        return R.ok().put("data", yundongleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YundongleixingEntity yundongleixing = yundongleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yundongleixing,deSens);
        return R.ok().put("data", yundongleixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YundongleixingEntity yundongleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yundongleixing);
        yundongleixingService.insert(yundongleixing);
        return R.ok().put("data",yundongleixing.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YundongleixingEntity yundongleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yundongleixing);
        yundongleixingService.insert(yundongleixing);
        return R.ok().put("data",yundongleixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YundongleixingEntity yundongleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yundongleixing);
        //全部更新
        yundongleixingService.updateById(yundongleixing);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yundongleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
