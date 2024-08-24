package com.cl.dao;

import com.cl.entity.DiaodujinduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiaodujinduView;


/**
 * 调度进度
 * 
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface DiaodujinduDao extends BaseMapper<DiaodujinduEntity> {
	
	List<DiaodujinduView> selectListView(@Param("ew") Wrapper<DiaodujinduEntity> wrapper);

	List<DiaodujinduView> selectListView(Pagination page,@Param("ew") Wrapper<DiaodujinduEntity> wrapper);
	
	DiaodujinduView selectView(@Param("ew") Wrapper<DiaodujinduEntity> wrapper);
	

}
