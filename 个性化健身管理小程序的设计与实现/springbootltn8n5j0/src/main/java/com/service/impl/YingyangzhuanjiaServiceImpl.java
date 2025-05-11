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


import com.dao.YingyangzhuanjiaDao;
import com.entity.YingyangzhuanjiaEntity;
import com.service.YingyangzhuanjiaService;
import com.entity.vo.YingyangzhuanjiaVO;
import com.entity.view.YingyangzhuanjiaView;

@Service("yingyangzhuanjiaService")
public class YingyangzhuanjiaServiceImpl extends ServiceImpl<YingyangzhuanjiaDao, YingyangzhuanjiaEntity> implements YingyangzhuanjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YingyangzhuanjiaEntity> page = this.selectPage(
                new Query<YingyangzhuanjiaEntity>(params).getPage(),
                new EntityWrapper<YingyangzhuanjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YingyangzhuanjiaEntity> wrapper) {
		  Page<YingyangzhuanjiaView> page =new Query<YingyangzhuanjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YingyangzhuanjiaVO> selectListVO(Wrapper<YingyangzhuanjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YingyangzhuanjiaVO selectVO(Wrapper<YingyangzhuanjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YingyangzhuanjiaView> selectListView(Wrapper<YingyangzhuanjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YingyangzhuanjiaView selectView(Wrapper<YingyangzhuanjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
