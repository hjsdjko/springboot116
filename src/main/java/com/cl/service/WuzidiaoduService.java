package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WuzidiaoduEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WuzidiaoduView;


/**
 * 物资调度
 *
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface WuzidiaoduService extends IService<WuzidiaoduEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WuzidiaoduView> selectListView(Wrapper<WuzidiaoduEntity> wrapper);
   	
   	WuzidiaoduView selectView(@Param("ew") Wrapper<WuzidiaoduEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WuzidiaoduEntity> wrapper);
   	

}

