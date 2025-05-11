package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JianshenzhuanjiaDao;
import com.entity.JianshenzhuanjiaEntity;
import com.service.JianshenzhuanjiaService;
import com.entity.vo.JianshenzhuanjiaVO;
import com.entity.view.JianshenzhuanjiaView;

@Service("jianshenzhuanjiaService")
public class JianshenzhuanjiaServiceImpl extends ServiceImpl<JianshenzhuanjiaDao, JianshenzhuanjiaEntity> implements JianshenzhuanjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianshenzhuanjiaEntity> page = this.selectPage(
                new Query<JianshenzhuanjiaEntity>(params).getPage(),
                new EntityWrapper<JianshenzhuanjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianshenzhuanjiaEntity> wrapper) {
		  Page<JianshenzhuanjiaView> page =new Query<JianshenzhuanjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JianshenzhuanjiaVO> selectListVO(Wrapper<JianshenzhuanjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JianshenzhuanjiaVO selectVO(Wrapper<JianshenzhuanjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JianshenzhuanjiaView> selectListView(Wrapper<JianshenzhuanjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianshenzhuanjiaView selectView(Wrapper<JianshenzhuanjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
