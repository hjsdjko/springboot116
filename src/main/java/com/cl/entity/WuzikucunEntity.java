package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 物资库存
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
@TableName("wuzikucun")
public class WuzikucunEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WuzikucunEntity() {
		
	}
	
	public WuzikucunEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 物资名称
	 */
					
	private String wuzimingcheng;
	
	/**
	 * 物资种类
	 */
					
	private String wuzizhonglei;
	
	/**
	 * 物资图片
	 */
					
	private String wuzitupian;
	
	/**
	 * 数量
	 */
					
	private Integer shuliang;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：物资名称
	 */
	public void setWuzimingcheng(String wuzimingcheng) {
		this.wuzimingcheng = wuzimingcheng;
	}
	/**
	 * 获取：物资名称
	 */
	public String getWuzimingcheng() {
		return wuzimingcheng;
	}
	/**
	 * 设置：物资种类
	 */
	public void setWuzizhonglei(String wuzizhonglei) {
		this.wuzizhonglei = wuzizhonglei;
	}
	/**
	 * 获取：物资种类
	 */
	public String getWuzizhonglei() {
		return wuzizhonglei;
	}
	/**
	 * 设置：物资图片
	 */
	public void setWuzitupian(String wuzitupian) {
		this.wuzitupian = wuzitupian;
	}
	/**
	 * 获取：物资图片
	 */
	public String getWuzitupian() {
		return wuzitupian;
	}
	/**
	 * 设置：数量
	 */
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}

}
