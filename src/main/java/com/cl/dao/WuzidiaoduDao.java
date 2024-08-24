package com.cl.dao;

import com.cl.entity.WuzidiaoduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WuzidiaoduView;


/**
 * 物资调度
 * 
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface WuzidiaoduDao extends BaseMapper<WuzidiaoduEntity> {
	
	List<WuzidiaoduView> selectListView(@Param("ew") Wrapper<WuzidiaoduEntity> wrapper);

	List<WuzidiaoduView> selectListView(Pagination page,@Param("ew") Wrapper<WuzidiaoduEntity> wrapper);
	
	WuzidiaoduView selectView(@Param("ew") Wrapper<WuzidiaoduEntity> wrapper);
	

}
