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


import com.cl.dao.DiaoduyuanDao;
import com.cl.entity.DiaoduyuanEntity;
import com.cl.service.DiaoduyuanService;
import com.cl.entity.view.DiaoduyuanView;

@Service("diaoduyuanService")
public class DiaoduyuanServiceImpl extends ServiceImpl<DiaoduyuanDao, DiaoduyuanEntity> implements DiaoduyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiaoduyuanEntity> page = this.selectPage(
                new Query<DiaoduyuanEntity>(params).getPage(),
                new EntityWrapper<DiaoduyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiaoduyuanEntity> wrapper) {
		  Page<DiaoduyuanView> page =new Query<DiaoduyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiaoduyuanView> selectListView(Wrapper<DiaoduyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiaoduyuanView selectView(Wrapper<DiaoduyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
