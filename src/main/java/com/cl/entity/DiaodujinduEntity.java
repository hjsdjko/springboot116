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
 * 调度进度
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
@TableName("diaodujindu")
public class DiaodujinduEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DiaodujinduEntity() {
		
	}
	
	public DiaodujinduEntity(T t) {
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
	 * 调度编号
	 */
					
	private String diaodubianhao;
	
	/**
	 * 物资名称
	 */
					
	private String wuzimingcheng;
	
	/**
	 * 物资种类
	 */
					
	private String wuzizhonglei;
	
	/**
	 * 数量
	 */
					
	private String shuliang;
	
	/**
	 * 运输方式
	 */
					
	private String yunshufangshi;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 电话号码
	 */
					
	private String dianhuahaoma;
	
	/**
	 * 地址
	 */
					
	private String dizhi;
	
	/**
	 * 物流状态
	 */
					
	private String wuliuzhuangtai;
	
	/**
	 * 物流详情
	 */
					
	private String wuliuxiangqing;
	
	
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
	 * 设置：调度编号
	 */
	public void setDiaodubianhao(String diaodubianhao) {
		this.diaodubianhao = diaodubianhao;
	}
	/**
	 * 获取：调度编号
	 */
	public String getDiaodubianhao() {
		return diaodubianhao;
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
	 * 设置：数量
	 */
	public void setShuliang(String shuliang) {
		this.shuliang = shuliang;
	}
	/**
	 * 获取：数量
	 */
	public String getShuliang() {
		return shuliang;
	}
	/**
	 * 设置：运输方式
	 */
	public void setYunshufangshi(String yunshufangshi) {
		this.yunshufangshi = yunshufangshi;
	}
	/**
	 * 获取：运输方式
	 */
	public String getYunshufangshi() {
		return yunshufangshi;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：电话号码
	 */
	public void setDianhuahaoma(String dianhuahaoma) {
		this.dianhuahaoma = dianhuahaoma;
	}
	/**
	 * 获取：电话号码
	 */
	public String getDianhuahaoma() {
		return dianhuahaoma;
	}
	/**
	 * 设置：地址
	 */
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	/**
	 * 获取：地址
	 */
	public String getDizhi() {
		return dizhi;
	}
	/**
	 * 设置：物流状态
	 */
	public void setWuliuzhuangtai(String wuliuzhuangtai) {
		this.wuliuzhuangtai = wuliuzhuangtai;
	}
	/**
	 * 获取：物流状态
	 */
	public String getWuliuzhuangtai() {
		return wuliuzhuangtai;
	}
	/**
	 * 设置：物流详情
	 */
	public void setWuliuxiangqing(String wuliuxiangqing) {
		this.wuliuxiangqing = wuliuxiangqing;
	}
	/**
	 * 获取：物流详情
	 */
	public String getWuliuxiangqing() {
		return wuliuxiangqing;
	}

}
