package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WuzichukuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WuzichukuView;


/**
 * 物资出库
 *
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface WuzichukuService extends IService<WuzichukuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WuzichukuView> selectListView(Wrapper<WuzichukuEntity> wrapper);
   	
   	WuzichukuView selectView(@Param("ew") Wrapper<WuzichukuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WuzichukuEntity> wrapper);
   	

}

