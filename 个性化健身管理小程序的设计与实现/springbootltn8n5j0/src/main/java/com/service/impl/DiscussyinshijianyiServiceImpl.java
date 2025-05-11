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


import com.dao.DiscussyinshijianyiDao;
import com.entity.DiscussyinshijianyiEntity;
import com.service.DiscussyinshijianyiService;
import com.entity.vo.DiscussyinshijianyiVO;
import com.entity.view.DiscussyinshijianyiView;

@Service("discussyinshijianyiService")
public class DiscussyinshijianyiServiceImpl extends ServiceImpl<DiscussyinshijianyiDao, DiscussyinshijianyiEntity> implements DiscussyinshijianyiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyinshijianyiEntity> page = this.selectPage(
                new Query<DiscussyinshijianyiEntity>(params).getPage(),
                new EntityWrapper<DiscussyinshijianyiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyinshijianyiEntity> wrapper) {
		  Page<DiscussyinshijianyiView> page =new Query<DiscussyinshijianyiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussyinshijianyiVO> selectListVO(Wrapper<DiscussyinshijianyiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyinshijianyiVO selectVO(Wrapper<DiscussyinshijianyiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyinshijianyiView> selectListView(Wrapper<DiscussyinshijianyiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyinshijianyiView selectView(Wrapper<DiscussyinshijianyiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
