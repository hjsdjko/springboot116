package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.WuzidiaoduDao;
import com.cl.entity.WuzidiaoduEntity;
import com.cl.service.WuzidiaoduService;
import com.cl.entity.view.WuzidiaoduView;

@Service("wuzidiaoduService")
public class WuzidiaoduServiceImpl extends ServiceImpl<WuzidiaoduDao, WuzidiaoduEntity> implements WuzidiaoduService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WuzidiaoduEntity> page = this.selectPage(
                new Query<WuzidiaoduEntity>(params).getPage(),
                new EntityWrapper<WuzidiaoduEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WuzidiaoduEntity> wrapper) {
		  Page<WuzidiaoduView> page =new Query<WuzidiaoduView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WuzidiaoduView> selectListView(Wrapper<WuzidiaoduEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WuzidiaoduView selectView(Wrapper<WuzidiaoduEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
