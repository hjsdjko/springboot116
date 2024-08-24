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


import com.cl.dao.WuzirukuDao;
import com.cl.entity.WuzirukuEntity;
import com.cl.service.WuzirukuService;
import com.cl.entity.view.WuzirukuView;

@Service("wuzirukuService")
public class WuzirukuServiceImpl extends ServiceImpl<WuzirukuDao, WuzirukuEntity> implements WuzirukuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WuzirukuEntity> page = this.selectPage(
                new Query<WuzirukuEntity>(params).getPage(),
                new EntityWrapper<WuzirukuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WuzirukuEntity> wrapper) {
		  Page<WuzirukuView> page =new Query<WuzirukuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WuzirukuView> selectListView(Wrapper<WuzirukuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WuzirukuView selectView(Wrapper<WuzirukuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
