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

import com.entity.YinshijianyiEntity;
import com.entity.view.YinshijianyiView;

import com.service.YinshijianyiService;
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
 * 饮食建议
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-14 18:26:07
 */
@RestController
@RequestMapping("/yinshijianyi")
public class YinshijianyiController {
    @Autowired
    private YinshijianyiService yinshijianyiService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinshijianyiEntity yinshijianyi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yingyangzhuanjia")) {
			yinshijianyi.setYingyangshizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<YinshijianyiEntity> ew = new EntityWrapper<YinshijianyiEntity>();


        //查询结果
		PageUtils page = yinshijianyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshijianyi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YinshijianyiEntity yinshijianyi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YinshijianyiEntity> ew = new EntityWrapper<YinshijianyiEntity>();

        //查询结果
		PageUtils page = yinshijianyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshijianyi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinshijianyiEntity yinshijianyi){
       	EntityWrapper<YinshijianyiEntity> ew = new EntityWrapper<YinshijianyiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinshijianyi, "yinshijianyi")); 
        return R.ok().put("data", yinshijianyiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinshijianyiEntity yinshijianyi){
        EntityWrapper< YinshijianyiEntity> ew = new EntityWrapper< YinshijianyiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinshijianyi, "yinshijianyi")); 
		YinshijianyiView yinshijianyiView =  yinshijianyiService.selectView(ew);
		return R.ok("查询饮食建议成功").put("data", yinshijianyiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinshijianyiEntity yinshijianyi = yinshijianyiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yinshijianyi,deSens);
        return R.ok().put("data", yinshijianyi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinshijianyiEntity yinshijianyi = yinshijianyiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yinshijianyi,deSens);
        return R.ok().put("data", yinshijianyi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        YinshijianyiEntity yinshijianyi = yinshijianyiService.selectById(id);
        if(type.equals("1")) {
        	yinshijianyi.setThumbsupnum(yinshijianyi.getThumbsupnum()+1);
        } else {
        	yinshijianyi.setCrazilynum(yinshijianyi.getCrazilynum()+1);
        }
        yinshijianyiService.updateById(yinshijianyi);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinshijianyiEntity yinshijianyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinshijianyi);
        yinshijianyiService.insert(yinshijianyi);
        return R.ok().put("data",yinshijianyi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinshijianyiEntity yinshijianyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinshijianyi);
        yinshijianyiService.insert(yinshijianyi);
        return R.ok().put("data",yinshijianyi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinshijianyiEntity yinshijianyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinshijianyi);
        //全部更新
        yinshijianyiService.updateById(yinshijianyi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinshijianyiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
