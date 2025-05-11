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


import com.dao.JianyileixingDao;
import com.entity.JianyileixingEntity;
import com.service.JianyileixingService;
import com.entity.vo.JianyileixingVO;
import com.entity.view.JianyileixingView;

@Service("jianyileixingService")
public class JianyileixingServiceImpl extends ServiceImpl<JianyileixingDao, JianyileixingEntity> implements JianyileixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianyileixingEntity> page = this.selectPage(
                new Query<JianyileixingEntity>(params).getPage(),
                new EntityWrapper<JianyileixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianyileixingEntity> wrapper) {
		  Page<JianyileixingView> page =new Query<JianyileixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JianyileixingVO> selectListVO(Wrapper<JianyileixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JianyileixingVO selectVO(Wrapper<JianyileixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JianyileixingView> selectListView(Wrapper<JianyileixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianyileixingView selectView(Wrapper<JianyileixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
