package com.cl.dao;

import com.cl.entity.WuzirukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WuzirukuView;


/**
 * 物资入库
 * 
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface WuzirukuDao extends BaseMapper<WuzirukuEntity> {
	
	List<WuzirukuView> selectListView(@Param("ew") Wrapper<WuzirukuEntity> wrapper);

	List<WuzirukuView> selectListView(Pagination page,@Param("ew") Wrapper<WuzirukuEntity> wrapper);
	
	WuzirukuView selectView(@Param("ew") Wrapper<WuzirukuEntity> wrapper);
	

}
