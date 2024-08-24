package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiaoduyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiaoduyuanView;


/**
 * 调度员
 *
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface DiaoduyuanService extends IService<DiaoduyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiaoduyuanView> selectListView(Wrapper<DiaoduyuanEntity> wrapper);
   	
   	DiaoduyuanView selectView(@Param("ew") Wrapper<DiaoduyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiaoduyuanEntity> wrapper);
   	

}

