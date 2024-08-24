package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.WuzichukuEntity;
import com.cl.entity.view.WuzichukuView;

import com.cl.service.WuzichukuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 物资出库
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
@RestController
@RequestMapping("/wuzichuku")
public class WuzichukuController {
    @Autowired
    private WuzichukuService wuzichukuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WuzichukuEntity wuzichuku,
		HttpServletRequest request){
        EntityWrapper<WuzichukuEntity> ew = new EntityWrapper<WuzichukuEntity>();

		PageUtils page = wuzichukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wuzichuku), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WuzichukuEntity wuzichuku, 
		HttpServletRequest request){
        EntityWrapper<WuzichukuEntity> ew = new EntityWrapper<WuzichukuEntity>();

		PageUtils page = wuzichukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wuzichuku), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WuzichukuEntity wuzichuku){
       	EntityWrapper<WuzichukuEntity> ew = new EntityWrapper<WuzichukuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wuzichuku, "wuzichuku")); 
        return R.ok().put("data", wuzichukuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WuzichukuEntity wuzichuku){
        EntityWrapper< WuzichukuEntity> ew = new EntityWrapper< WuzichukuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wuzichuku, "wuzichuku")); 
		WuzichukuView wuzichukuView =  wuzichukuService.selectView(ew);
		return R.ok("查询物资出库成功").put("data", wuzichukuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WuzichukuEntity wuzichuku = wuzichukuService.selectById(id);
		wuzichuku = wuzichukuService.selectView(new EntityWrapper<WuzichukuEntity>().eq("id", id));
        return R.ok().put("data", wuzichuku);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WuzichukuEntity wuzichuku = wuzichukuService.selectById(id);
		wuzichuku = wuzichukuService.selectView(new EntityWrapper<WuzichukuEntity>().eq("id", id));
        return R.ok().put("data", wuzichuku);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WuzichukuEntity wuzichuku, HttpServletRequest request){
    	wuzichuku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wuzichuku);
        wuzichukuService.insert(wuzichuku);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WuzichukuEntity wuzichuku, HttpServletRequest request){
    	wuzichuku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wuzichuku);
        wuzichukuService.insert(wuzichuku);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WuzichukuEntity wuzichuku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wuzichuku);
        wuzichukuService.updateById(wuzichuku);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wuzichukuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
