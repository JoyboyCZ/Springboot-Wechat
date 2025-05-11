package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.entity.TokenEntity;
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

import com.entity.JianshenzhuanjiaEntity;
import com.entity.view.JianshenzhuanjiaView;

import com.service.JianshenzhuanjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 健身专家
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-14 18:26:05
 */
@RestController
@RequestMapping("/jianshenzhuanjia")
public class JianshenzhuanjiaController {
    @Autowired
    private JianshenzhuanjiaService jianshenzhuanjiaService;






    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据登录查询用户信息
        JianshenzhuanjiaEntity u = jianshenzhuanjiaService.selectOne(new EntityWrapper<JianshenzhuanjiaEntity>().eq("zhanghao", username));
        // 当用户不存在或验证密码不通过时
		if(u==null || !u.getMima().equals(password)) {
            //账号或密码不正确提示
			return R.error("账号或密码不正确");
		}
		
        // 获取登录token
		String token = tokenService.generateToken(u.getId(), username,"jianshenzhuanjia",  "健身专家" );
        //返回token
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody JianshenzhuanjiaEntity jianshenzhuanjia){
    	//ValidatorUtils.validateEntity(jianshenzhuanjia);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	JianshenzhuanjiaEntity u = jianshenzhuanjiaService.selectOne(new EntityWrapper<JianshenzhuanjiaEntity>().eq("zhanghao", jianshenzhuanjia.getZhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //判断是否存在相同账号，否则返回错误信息
        if(jianshenzhuanjiaService.selectCount(new EntityWrapper<JianshenzhuanjiaEntity>().eq("zhanghao", jianshenzhuanjia.getZhanghao()))>0) {
            return R.error("账号已存在");
        }
		Long uId = new Date().getTime();
		jianshenzhuanjia.setId(uId);
        //保存用户
        jianshenzhuanjiaService.insert(jianshenzhuanjia);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        JianshenzhuanjiaEntity u = jianshenzhuanjiaService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        JianshenzhuanjiaEntity u = jianshenzhuanjiaService.selectOne(new EntityWrapper<JianshenzhuanjiaEntity>().eq("zhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456
        u.setMima("123456");
        jianshenzhuanjiaService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianshenzhuanjiaEntity jianshenzhuanjia,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JianshenzhuanjiaEntity> ew = new EntityWrapper<JianshenzhuanjiaEntity>();


        //查询结果
		PageUtils page = jianshenzhuanjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenzhuanjia), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JianshenzhuanjiaEntity jianshenzhuanjia, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JianshenzhuanjiaEntity> ew = new EntityWrapper<JianshenzhuanjiaEntity>();

        //查询结果
		PageUtils page = jianshenzhuanjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenzhuanjia), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianshenzhuanjiaEntity jianshenzhuanjia){
       	EntityWrapper<JianshenzhuanjiaEntity> ew = new EntityWrapper<JianshenzhuanjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianshenzhuanjia, "jianshenzhuanjia")); 
        return R.ok().put("data", jianshenzhuanjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianshenzhuanjiaEntity jianshenzhuanjia){
        EntityWrapper< JianshenzhuanjiaEntity> ew = new EntityWrapper< JianshenzhuanjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianshenzhuanjia, "jianshenzhuanjia")); 
		JianshenzhuanjiaView jianshenzhuanjiaView =  jianshenzhuanjiaService.selectView(ew);
		return R.ok("查询健身专家成功").put("data", jianshenzhuanjiaView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianshenzhuanjiaEntity jianshenzhuanjia = jianshenzhuanjiaService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jianshenzhuanjia,deSens);
        return R.ok().put("data", jianshenzhuanjia);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianshenzhuanjiaEntity jianshenzhuanjia = jianshenzhuanjiaService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jianshenzhuanjia,deSens);
        return R.ok().put("data", jianshenzhuanjia);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianshenzhuanjiaEntity jianshenzhuanjia, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(jianshenzhuanjiaService.selectCount(new EntityWrapper<JianshenzhuanjiaEntity>().eq("zhanghao", jianshenzhuanjia.getZhanghao()))>0) {
            return R.error("账号已存在");
        }
        //ValidatorUtils.validateEntity(jianshenzhuanjia);
        //验证账号唯一性，否则返回错误信息
        JianshenzhuanjiaEntity u = jianshenzhuanjiaService.selectOne(new EntityWrapper<JianshenzhuanjiaEntity>().eq("zhanghao", jianshenzhuanjia.getZhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	jianshenzhuanjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		jianshenzhuanjia.setId(new Date().getTime());
        jianshenzhuanjiaService.insert(jianshenzhuanjia);
        return R.ok().put("data",jianshenzhuanjia.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianshenzhuanjiaEntity jianshenzhuanjia, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(jianshenzhuanjiaService.selectCount(new EntityWrapper<JianshenzhuanjiaEntity>().eq("zhanghao", jianshenzhuanjia.getZhanghao()))>0) {
            return R.error("账号已存在");
        }
        //ValidatorUtils.validateEntity(jianshenzhuanjia);
        //验证账号唯一性，否则返回错误信息
        JianshenzhuanjiaEntity u = jianshenzhuanjiaService.selectOne(new EntityWrapper<JianshenzhuanjiaEntity>().eq("zhanghao", jianshenzhuanjia.getZhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	jianshenzhuanjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		jianshenzhuanjia.setId(new Date().getTime());
        jianshenzhuanjiaService.insert(jianshenzhuanjia);
        return R.ok().put("data",jianshenzhuanjia.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianshenzhuanjiaEntity jianshenzhuanjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianshenzhuanjia);
        //验证字段唯一性，否则返回错误信息
        if(jianshenzhuanjiaService.selectCount(new EntityWrapper<JianshenzhuanjiaEntity>().ne("id", jianshenzhuanjia.getId()).eq("zhanghao", jianshenzhuanjia.getZhanghao()))>0) {
            return R.error("账号已存在");
        }
        //全部更新
        jianshenzhuanjiaService.updateById(jianshenzhuanjia);
        if(null!=jianshenzhuanjia.getZhanghao())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(jianshenzhuanjia.getZhanghao());
            tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", jianshenzhuanjia.getId()));
        }
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianshenzhuanjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
