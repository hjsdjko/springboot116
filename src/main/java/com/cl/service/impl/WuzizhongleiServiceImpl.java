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


import com.cl.dao.WuzizhongleiDao;
import com.cl.entity.WuzizhongleiEntity;
import com.cl.service.WuzizhongleiService;
import com.cl.entity.view.WuzizhongleiView;

@Service("wuzizhongleiService")
public class WuzizhongleiServiceImpl extends ServiceImpl<WuzizhongleiDao, WuzizhongleiEntity> implements WuzizhongleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WuzizhongleiEntity> page = this.selectPage(
                new Query<WuzizhongleiEntity>(params).getPage(),
                new EntityWrapper<WuzizhongleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WuzizhongleiEntity> wrapper) {
		  Page<WuzizhongleiView> page =new Query<WuzizhongleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WuzizhongleiView> selectListView(Wrapper<WuzizhongleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WuzizhongleiView selectView(Wrapper<WuzizhongleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
