package com.cl.dao;

import com.cl.entity.WuzizhongleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WuzizhongleiView;


/**
 * 物资种类
 * 
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface WuzizhongleiDao extends BaseMapper<WuzizhongleiEntity> {
	
	List<WuzizhongleiView> selectListView(@Param("ew") Wrapper<WuzizhongleiEntity> wrapper);

	List<WuzizhongleiView> selectListView(Pagination page,@Param("ew") Wrapper<WuzizhongleiEntity> wrapper);
	
	WuzizhongleiView selectView(@Param("ew") Wrapper<WuzizhongleiEntity> wrapper);
	

}
