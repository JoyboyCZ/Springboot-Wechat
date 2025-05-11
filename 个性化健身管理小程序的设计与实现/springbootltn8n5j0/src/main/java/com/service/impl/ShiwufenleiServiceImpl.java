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


import com.dao.ShiwufenleiDao;
import com.entity.ShiwufenleiEntity;
import com.service.ShiwufenleiService;
import com.entity.vo.ShiwufenleiVO;
import com.entity.view.ShiwufenleiView;

@Service("shiwufenleiService")
public class ShiwufenleiServiceImpl extends ServiceImpl<ShiwufenleiDao, ShiwufenleiEntity> implements ShiwufenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShiwufenleiEntity> page = this.selectPage(
                new Query<ShiwufenleiEntity>(params).getPage(),
                new EntityWrapper<ShiwufenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShiwufenleiEntity> wrapper) {
		  Page<ShiwufenleiView> page =new Query<ShiwufenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShiwufenleiVO> selectListVO(Wrapper<ShiwufenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShiwufenleiVO selectVO(Wrapper<ShiwufenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShiwufenleiView> selectListView(Wrapper<ShiwufenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShiwufenleiView selectView(Wrapper<ShiwufenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
