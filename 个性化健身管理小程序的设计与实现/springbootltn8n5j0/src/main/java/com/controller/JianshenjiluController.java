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

import com.entity.JianshenjiluEntity;
import com.entity.view.JianshenjiluView;

import com.service.JianshenjiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 健身记录
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
@RestController
@RequestMapping("/jianshenjilu")
public class JianshenjiluController {
    @Autowired
    private JianshenjiluService jianshenjiluService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianshenjiluEntity jianshenjilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jianshenjilu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<JianshenjiluEntity> ew = new EntityWrapper<JianshenjiluEntity>();


        //查询结果
		PageUtils page = jianshenjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenjilu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JianshenjiluEntity jianshenjilu, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JianshenjiluEntity> ew = new EntityWrapper<JianshenjiluEntity>();

        //查询结果
		PageUtils page = jianshenjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenjilu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianshenjiluEntity jianshenjilu){
       	EntityWrapper<JianshenjiluEntity> ew = new EntityWrapper<JianshenjiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianshenjilu, "jianshenjilu")); 
        return R.ok().put("data", jianshenjiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianshenjiluEntity jianshenjilu){
        EntityWrapper< JianshenjiluEntity> ew = new EntityWrapper< JianshenjiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianshenjilu, "jianshenjilu")); 
		JianshenjiluView jianshenjiluView =  jianshenjiluService.selectView(ew);
		return R.ok("查询健身记录成功").put("data", jianshenjiluView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianshenjiluEntity jianshenjilu = jianshenjiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jianshenjilu,deSens);
        return R.ok().put("data", jianshenjilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianshenjiluEntity jianshenjilu = jianshenjiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jianshenjilu,deSens);
        return R.ok().put("data", jianshenjilu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianshenjiluEntity jianshenjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianshenjilu);
        jianshenjiluService.insert(jianshenjilu);
        return R.ok().put("data",jianshenjilu.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianshenjiluEntity jianshenjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianshenjilu);
        jianshenjiluService.insert(jianshenjilu);
        return R.ok().put("data",jianshenjilu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianshenjiluEntity jianshenjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianshenjilu);
        //全部更新
        jianshenjiluService.updateById(jianshenjilu);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianshenjiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
