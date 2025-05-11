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


import com.dao.YinshidingzhiDao;
import com.entity.YinshidingzhiEntity;
import com.service.YinshidingzhiService;
import com.entity.vo.YinshidingzhiVO;
import com.entity.view.YinshidingzhiView;

@Service("yinshidingzhiService")
public class YinshidingzhiServiceImpl extends ServiceImpl<YinshidingzhiDao, YinshidingzhiEntity> implements YinshidingzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinshidingzhiEntity> page = this.selectPage(
                new Query<YinshidingzhiEntity>(params).getPage(),
                new EntityWrapper<YinshidingzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinshidingzhiEntity> wrapper) {
		  Page<YinshidingzhiView> page =new Query<YinshidingzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YinshidingzhiVO> selectListVO(Wrapper<YinshidingzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YinshidingzhiVO selectVO(Wrapper<YinshidingzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YinshidingzhiView> selectListView(Wrapper<YinshidingzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinshidingzhiView selectView(Wrapper<YinshidingzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
