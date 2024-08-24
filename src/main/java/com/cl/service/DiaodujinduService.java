package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiaodujinduEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiaodujinduView;


/**
 * 调度进度
 *
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface DiaodujinduService extends IService<DiaodujinduEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiaodujinduView> selectListView(Wrapper<DiaodujinduEntity> wrapper);
   	
   	DiaodujinduView selectView(@Param("ew") Wrapper<DiaodujinduEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiaodujinduEntity> wrapper);
   	

}

