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


import com.cl.dao.WuzixuqiuDao;
import com.cl.entity.WuzixuqiuEntity;
import com.cl.service.WuzixuqiuService;
import com.cl.entity.view.WuzixuqiuView;

@Service("wuzixuqiuService")
public class WuzixuqiuServiceImpl extends ServiceImpl<WuzixuqiuDao, WuzixuqiuEntity> implements WuzixuqiuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WuzixuqiuEntity> page = this.selectPage(
                new Query<WuzixuqiuEntity>(params).getPage(),
                new EntityWrapper<WuzixuqiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WuzixuqiuEntity> wrapper) {
		  Page<WuzixuqiuView> page =new Query<WuzixuqiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WuzixuqiuView> selectListView(Wrapper<WuzixuqiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WuzixuqiuView selectView(Wrapper<WuzixuqiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
