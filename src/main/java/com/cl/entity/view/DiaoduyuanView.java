package com.cl.entity.view;

import com.cl.entity.DiaoduyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 调度员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
@TableName("diaoduyuan")
public class DiaoduyuanView  extends DiaoduyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiaoduyuanView(){
	}
 
 	public DiaoduyuanView(DiaoduyuanEntity diaoduyuanEntity){
 	try {
			BeanUtils.copyProperties(this, diaoduyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
