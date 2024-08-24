package com.cl.dao;

import com.cl.entity.DiaoduyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiaoduyuanView;


/**
 * 调度员
 * 
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface DiaoduyuanDao extends BaseMapper<DiaoduyuanEntity> {
	
	List<DiaoduyuanView> selectListView(@Param("ew") Wrapper<DiaoduyuanEntity> wrapper);

	List<DiaoduyuanView> selectListView(Pagination page,@Param("ew") Wrapper<DiaoduyuanEntity> wrapper);
	
	DiaoduyuanView selectView(@Param("ew") Wrapper<DiaoduyuanEntity> wrapper);
	

}
