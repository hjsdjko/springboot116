package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WuzirukuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WuzirukuView;


/**
 * 物资入库
 *
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface WuzirukuService extends IService<WuzirukuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WuzirukuView> selectListView(Wrapper<WuzirukuEntity> wrapper);
   	
   	WuzirukuView selectView(@Param("ew") Wrapper<WuzirukuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WuzirukuEntity> wrapper);
   	

}

