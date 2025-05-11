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


import com.dao.DiscussjianshenjianyiDao;
import com.entity.DiscussjianshenjianyiEntity;
import com.service.DiscussjianshenjianyiService;
import com.entity.vo.DiscussjianshenjianyiVO;
import com.entity.view.DiscussjianshenjianyiView;

@Service("discussjianshenjianyiService")
public class DiscussjianshenjianyiServiceImpl extends ServiceImpl<DiscussjianshenjianyiDao, DiscussjianshenjianyiEntity> implements DiscussjianshenjianyiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjianshenjianyiEntity> page = this.selectPage(
                new Query<DiscussjianshenjianyiEntity>(params).getPage(),
                new EntityWrapper<DiscussjianshenjianyiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjianshenjianyiEntity> wrapper) {
		  Page<DiscussjianshenjianyiView> page =new Query<DiscussjianshenjianyiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussjianshenjianyiVO> selectListVO(Wrapper<DiscussjianshenjianyiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjianshenjianyiVO selectVO(Wrapper<DiscussjianshenjianyiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjianshenjianyiView> selectListView(Wrapper<DiscussjianshenjianyiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjianshenjianyiView selectView(Wrapper<DiscussjianshenjianyiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
