package com.cl.entity.view;

import com.cl.entity.DiaodujinduEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 调度进度
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
@TableName("diaodujindu")
public class DiaodujinduView  extends DiaodujinduEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiaodujinduView(){
	}
 
 	public DiaodujinduView(DiaodujinduEntity diaodujinduEntity){
 	try {
			BeanUtils.copyProperties(this, diaodujinduEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}