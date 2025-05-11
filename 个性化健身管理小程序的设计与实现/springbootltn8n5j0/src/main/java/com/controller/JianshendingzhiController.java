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

import com.entity.JianshendingzhiEntity;
import com.entity.view.JianshendingzhiView;

import com.service.JianshendingzhiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 健身定制
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-14 18:26:06
 */
@RestController
@RequestMapping("/jianshendingzhi")
public class JianshendingzhiController {
    @Autowired
    private JianshendingzhiService jianshendingzhiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianshendingzhiEntity jianshendingzhi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jianshendingzhi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jianshenzhuanjia")) {
			jianshendingzhi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<JianshendingzhiEntity> ew = new EntityWrapper<JianshendingzhiEntity>();


        //查询结果
		PageUtils page = jianshendingzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshendingzhi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JianshendingzhiEntity jianshendingzhi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JianshendingzhiEntity> ew = new EntityWrapper<JianshendingzhiEntity>();

        //查询结果
		PageUtils page = jianshendingzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshendingzhi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianshendingzhiEntity jianshendingzhi){
       	EntityWrapper<JianshendingzhiEntity> ew = new EntityWrapper<JianshendingzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianshendingzhi, "jianshendingzhi")); 
        return R.ok().put("data", jianshendingzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianshendingzhiEntity jianshendingzhi){
        EntityWrapper< JianshendingzhiEntity> ew = new EntityWrapper< JianshendingzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianshendingzhi, "jianshendingzhi")); 
		JianshendingzhiView jianshendingzhiView =  jianshendingzhiService.selectView(ew);
		return R.ok("查询健身定制成功").put("data", jianshendingzhiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianshendingzhiEntity jianshendingzhi = jianshendingzhiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jianshendingzhi,deSens);
        return R.ok().put("data", jianshendingzhi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianshendingzhiEntity jianshendingzhi = jianshendingzhiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jianshendingzhi,deSens);
        return R.ok().put("data", jianshendingzhi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianshendingzhiEntity jianshendingzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianshendingzhi);
        jianshendingzhiService.insert(jianshendingzhi);
        return R.ok().put("data",jianshendingzhi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianshendingzhiEntity jianshendingzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianshendingzhi);
        jianshendingzhiService.insert(jianshendingzhi);
        return R.ok().put("data",jianshendingzhi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianshendingzhiEntity jianshendingzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianshendingzhi);
        //全部更新
        jianshendingzhiService.updateById(jianshendingzhi);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<JianshendingzhiEntity> list = new ArrayList<JianshendingzhiEntity>();
        for(Long id : ids) {
            JianshendingzhiEntity jianshendingzhi = jianshendingzhiService.selectById(id);
            jianshendingzhi.setSfsh(sfsh);
            jianshendingzhi.setShhf(shhf);
            list.add(jianshendingzhi);
        }
        jianshendingzhiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianshendingzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
