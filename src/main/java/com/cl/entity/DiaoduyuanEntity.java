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
 * 调度员
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
@TableName("diaoduyuan")
public class DiaoduyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DiaoduyuanEntity() {
		
	}
	
	public DiaoduyuanEntity(T t) {
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
	 * 调度员工号
	 */
					
	private String diaoduyuangonghao;
	
	/**
	 * 调度员密码
	 */
					
	private String diaoduyuanmima;
	
	/**
	 * 调度员姓名
	 */
					
	private String diaoduyuanxingming;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 身份证号
	 */
					
	private String shenfenzhenghao;
	
	
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
	 * 设置：调度员工号
	 */
	public void setDiaoduyuangonghao(String diaoduyuangonghao) {
		this.diaoduyuangonghao = diaoduyuangonghao;
	}
	/**
	 * 获取：调度员工号
	 */
	public String getDiaoduyuangonghao() {
		return diaoduyuangonghao;
	}
	/**
	 * 设置：调度员密码
	 */
	public void setDiaoduyuanmima(String diaoduyuanmima) {
		this.diaoduyuanmima = diaoduyuanmima;
	}
	/**
	 * 获取：调度员密码
	 */
	public String getDiaoduyuanmima() {
		return diaoduyuanmima;
	}
	/**
	 * 设置：调度员姓名
	 */
	public void setDiaoduyuanxingming(String diaoduyuanxingming) {
		this.diaoduyuanxingming = diaoduyuanxingming;
	}
	/**
	 * 获取：调度员姓名
	 */
	public String getDiaoduyuanxingming() {
		return diaoduyuanxingming;
	}
	/**
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：身份证号
	 */
	public void setShenfenzhenghao(String shenfenzhenghao) {
		this.shenfenzhenghao = shenfenzhenghao;
	}
	/**
	 * 获取：身份证号
	 */
	public String getShenfenzhenghao() {
		return shenfenzhenghao;
	}

}
