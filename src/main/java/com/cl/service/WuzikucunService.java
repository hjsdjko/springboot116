package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WuzikucunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WuzikucunView;


/**
 * 物资库存
 *
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface WuzikucunService extends IService<WuzikucunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WuzikucunView> selectListView(Wrapper<WuzikucunEntity> wrapper);
   	
   	WuzikucunView selectView(@Param("ew") Wrapper<WuzikucunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WuzikucunEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<WuzikucunEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<WuzikucunEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<WuzikucunEntity> wrapper);



}

