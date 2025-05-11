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


import com.dao.JianshenjinduDao;
import com.entity.JianshenjinduEntity;
import com.service.JianshenjinduService;
import com.entity.vo.JianshenjinduVO;
import com.entity.view.JianshenjinduView;

@Service("jianshenjinduService")
public class JianshenjinduServiceImpl extends ServiceImpl<JianshenjinduDao, JianshenjinduEntity> implements JianshenjinduService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianshenjinduEntity> page = this.selectPage(
                new Query<JianshenjinduEntity>(params).getPage(),
                new EntityWrapper<JianshenjinduEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianshenjinduEntity> wrapper) {
		  Page<JianshenjinduView> page =new Query<JianshenjinduView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JianshenjinduVO> selectListVO(Wrapper<JianshenjinduEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JianshenjinduVO selectVO(Wrapper<JianshenjinduEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JianshenjinduView> selectListView(Wrapper<JianshenjinduEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianshenjinduView selectView(Wrapper<JianshenjinduEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
