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

import com.entity.YinshidingzhiEntity;
import com.entity.view.YinshidingzhiView;

import com.service.YinshidingzhiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 饮食定制
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-14 18:26:07
 */
@RestController
@RequestMapping("/yinshidingzhi")
public class YinshidingzhiController {
    @Autowired
    private YinshidingzhiService yinshidingzhiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinshidingzhiEntity yinshidingzhi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yinshidingzhi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yingyangzhuanjia")) {
			yinshidingzhi.setYingyangshizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<YinshidingzhiEntity> ew = new EntityWrapper<YinshidingzhiEntity>();


        //查询结果
		PageUtils page = yinshidingzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshidingzhi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YinshidingzhiEntity yinshidingzhi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YinshidingzhiEntity> ew = new EntityWrapper<YinshidingzhiEntity>();

        //查询结果
		PageUtils page = yinshidingzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshidingzhi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinshidingzhiEntity yinshidingzhi){
       	EntityWrapper<YinshidingzhiEntity> ew = new EntityWrapper<YinshidingzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinshidingzhi, "yinshidingzhi")); 
        return R.ok().put("data", yinshidingzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinshidingzhiEntity yinshidingzhi){
        EntityWrapper< YinshidingzhiEntity> ew = new EntityWrapper< YinshidingzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinshidingzhi, "yinshidingzhi")); 
		YinshidingzhiView yinshidingzhiView =  yinshidingzhiService.selectView(ew);
		return R.ok("查询饮食定制成功").put("data", yinshidingzhiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinshidingzhiEntity yinshidingzhi = yinshidingzhiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yinshidingzhi,deSens);
        return R.ok().put("data", yinshidingzhi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinshidingzhiEntity yinshidingzhi = yinshidingzhiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yinshidingzhi,deSens);
        return R.ok().put("data", yinshidingzhi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinshidingzhiEntity yinshidingzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinshidingzhi);
        yinshidingzhiService.insert(yinshidingzhi);
        return R.ok().put("data",yinshidingzhi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinshidingzhiEntity yinshidingzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinshidingzhi);
        yinshidingzhiService.insert(yinshidingzhi);
        return R.ok().put("data",yinshidingzhi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinshidingzhiEntity yinshidingzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinshidingzhi);
        //全部更新
        yinshidingzhiService.updateById(yinshidingzhi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinshidingzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
