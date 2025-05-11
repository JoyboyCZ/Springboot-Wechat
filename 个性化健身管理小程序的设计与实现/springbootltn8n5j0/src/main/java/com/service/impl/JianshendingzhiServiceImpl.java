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


import com.dao.JianshendingzhiDao;
import com.entity.JianshendingzhiEntity;
import com.service.JianshendingzhiService;
import com.entity.vo.JianshendingzhiVO;
import com.entity.view.JianshendingzhiView;

@Service("jianshendingzhiService")
public class JianshendingzhiServiceImpl extends ServiceImpl<JianshendingzhiDao, JianshendingzhiEntity> implements JianshendingzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianshendingzhiEntity> page = this.selectPage(
                new Query<JianshendingzhiEntity>(params).getPage(),
                new EntityWrapper<JianshendingzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianshendingzhiEntity> wrapper) {
		  Page<JianshendingzhiView> page =new Query<JianshendingzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JianshendingzhiVO> selectListVO(Wrapper<JianshendingzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JianshendingzhiVO selectVO(Wrapper<JianshendingzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JianshendingzhiView> selectListView(Wrapper<JianshendingzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianshendingzhiView selectView(Wrapper<JianshendingzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
