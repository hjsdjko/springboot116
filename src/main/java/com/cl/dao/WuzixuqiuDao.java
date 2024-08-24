package com.cl.dao;

import com.cl.entity.WuzixuqiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WuzixuqiuView;


/**
 * 物资需求
 * 
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface WuzixuqiuDao extends BaseMapper<WuzixuqiuEntity> {
	
	List<WuzixuqiuView> selectListView(@Param("ew") Wrapper<WuzixuqiuEntity> wrapper);

	List<WuzixuqiuView> selectListView(Pagination page,@Param("ew") Wrapper<WuzixuqiuEntity> wrapper);
	
	WuzixuqiuView selectView(@Param("ew") Wrapper<WuzixuqiuEntity> wrapper);
	

}
