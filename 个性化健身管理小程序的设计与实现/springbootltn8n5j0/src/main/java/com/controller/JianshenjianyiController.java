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

import com.entity.JianshenjianyiEntity;
import com.entity.view.JianshenjianyiView;

import com.service.JianshenjianyiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 健身建议
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-14 18:26:05
 */
@RestController
@RequestMapping("/jianshenjianyi")
public class JianshenjianyiController {
    @Autowired
    private JianshenjianyiService jianshenjianyiService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianshenjianyiEntity jianshenjianyi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jianshenzhuanjia")) {
			jianshenjianyi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<JianshenjianyiEntity> ew = new EntityWrapper<JianshenjianyiEntity>();


        //查询结果
		PageUtils page = jianshenjianyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenjianyi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JianshenjianyiEntity jianshenjianyi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JianshenjianyiEntity> ew = new EntityWrapper<JianshenjianyiEntity>();

        //查询结果
		PageUtils page = jianshenjianyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenjianyi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianshenjianyiEntity jianshenjianyi){
       	EntityWrapper<JianshenjianyiEntity> ew = new EntityWrapper<JianshenjianyiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianshenjianyi, "jianshenjianyi")); 
        return R.ok().put("data", jianshenjianyiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianshenjianyiEntity jianshenjianyi){
        EntityWrapper< JianshenjianyiEntity> ew = new EntityWrapper< JianshenjianyiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianshenjianyi, "jianshenjianyi")); 
		JianshenjianyiView jianshenjianyiView =  jianshenjianyiService.selectView(ew);
		return R.ok("查询健身建议成功").put("data", jianshenjianyiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianshenjianyiEntity jianshenjianyi = jianshenjianyiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jianshenjianyi,deSens);
        return R.ok().put("data", jianshenjianyi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianshenjianyiEntity jianshenjianyi = jianshenjianyiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jianshenjianyi,deSens);
        return R.ok().put("data", jianshenjianyi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        JianshenjianyiEntity jianshenjianyi = jianshenjianyiService.selectById(id);
        if(type.equals("1")) {
        	jianshenjianyi.setThumbsupnum(jianshenjianyi.getThumbsupnum()+1);
        } else {
        	jianshenjianyi.setCrazilynum(jianshenjianyi.getCrazilynum()+1);
        }
        jianshenjianyiService.updateById(jianshenjianyi);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianshenjianyiEntity jianshenjianyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianshenjianyi);
        jianshenjianyiService.insert(jianshenjianyi);
        return R.ok().put("data",jianshenjianyi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianshenjianyiEntity jianshenjianyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianshenjianyi);
        jianshenjianyiService.insert(jianshenjianyi);
        return R.ok().put("data",jianshenjianyi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianshenjianyiEntity jianshenjianyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianshenjianyi);
        //全部更新
        jianshenjianyiService.updateById(jianshenjianyi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianshenjianyiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
