package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WuzixuqiuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WuzixuqiuView;


/**
 * 物资需求
 *
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface WuzixuqiuService extends IService<WuzixuqiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WuzixuqiuView> selectListView(Wrapper<WuzixuqiuEntity> wrapper);
   	
   	WuzixuqiuView selectView(@Param("ew") Wrapper<WuzixuqiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WuzixuqiuEntity> wrapper);
   	

}

