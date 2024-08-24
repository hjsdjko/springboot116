package com.cl.dao;

import com.cl.entity.WuzichukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WuzichukuView;


/**
 * 物资出库
 * 
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface WuzichukuDao extends BaseMapper<WuzichukuEntity> {
	
	List<WuzichukuView> selectListView(@Param("ew") Wrapper<WuzichukuEntity> wrapper);

	List<WuzichukuView> selectListView(Pagination page,@Param("ew") Wrapper<WuzichukuEntity> wrapper);
	
	WuzichukuView selectView(@Param("ew") Wrapper<WuzichukuEntity> wrapper);
	

}
