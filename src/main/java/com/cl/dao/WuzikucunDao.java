package com.cl.dao;

import com.cl.entity.WuzikucunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WuzikucunView;


/**
 * 物资库存
 * 
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface WuzikucunDao extends BaseMapper<WuzikucunEntity> {
	
	List<WuzikucunView> selectListView(@Param("ew") Wrapper<WuzikucunEntity> wrapper);

	List<WuzikucunView> selectListView(Pagination page,@Param("ew") Wrapper<WuzikucunEntity> wrapper);
	
	WuzikucunView selectView(@Param("ew") Wrapper<WuzikucunEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<WuzikucunEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<WuzikucunEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<WuzikucunEntity> wrapper);



}
