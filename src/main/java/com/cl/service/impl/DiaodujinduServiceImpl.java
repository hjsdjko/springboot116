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


import com.cl.dao.DiaodujinduDao;
import com.cl.entity.DiaodujinduEntity;
import com.cl.service.DiaodujinduService;
import com.cl.entity.view.DiaodujinduView;

@Service("diaodujinduService")
public class DiaodujinduServiceImpl extends ServiceImpl<DiaodujinduDao, DiaodujinduEntity> implements DiaodujinduService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiaodujinduEntity> page = this.selectPage(
                new Query<DiaodujinduEntity>(params).getPage(),
                new EntityWrapper<DiaodujinduEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiaodujinduEntity> wrapper) {
		  Page<DiaodujinduView> page =new Query<DiaodujinduView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiaodujinduView> selectListView(Wrapper<DiaodujinduEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiaodujinduView selectView(Wrapper<DiaodujinduEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
