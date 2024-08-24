package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WuzizhongleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WuzizhongleiView;


/**
 * 物资种类
 *
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
public interface WuzizhongleiService extends IService<WuzizhongleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WuzizhongleiView> selectListView(Wrapper<WuzizhongleiEntity> wrapper);
   	
   	WuzizhongleiView selectView(@Param("ew") Wrapper<WuzizhongleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WuzizhongleiEntity> wrapper);
   	

}

