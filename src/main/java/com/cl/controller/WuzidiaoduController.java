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

import com.cl.entity.WuzidiaoduEntity;
import com.cl.entity.view.WuzidiaoduView;

import com.cl.service.WuzidiaoduService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 物资调度
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
@RestController
@RequestMapping("/wuzidiaodu")
public class WuzidiaoduController {
    @Autowired
    private WuzidiaoduService wuzidiaoduService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WuzidiaoduEntity wuzidiaodu,
		HttpServletRequest request){
        EntityWrapper<WuzidiaoduEntity> ew = new EntityWrapper<WuzidiaoduEntity>();

		PageUtils page = wuzidiaoduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wuzidiaodu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WuzidiaoduEntity wuzidiaodu, 
		HttpServletRequest request){
        EntityWrapper<WuzidiaoduEntity> ew = new EntityWrapper<WuzidiaoduEntity>();

		PageUtils page = wuzidiaoduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wuzidiaodu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WuzidiaoduEntity wuzidiaodu){
       	EntityWrapper<WuzidiaoduEntity> ew = new EntityWrapper<WuzidiaoduEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wuzidiaodu, "wuzidiaodu")); 
        return R.ok().put("data", wuzidiaoduService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WuzidiaoduEntity wuzidiaodu){
        EntityWrapper< WuzidiaoduEntity> ew = new EntityWrapper< WuzidiaoduEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wuzidiaodu, "wuzidiaodu")); 
		WuzidiaoduView wuzidiaoduView =  wuzidiaoduService.selectView(ew);
		return R.ok("查询物资调度成功").put("data", wuzidiaoduView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WuzidiaoduEntity wuzidiaodu = wuzidiaoduService.selectById(id);
		wuzidiaodu = wuzidiaoduService.selectView(new EntityWrapper<WuzidiaoduEntity>().eq("id", id));
        return R.ok().put("data", wuzidiaodu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WuzidiaoduEntity wuzidiaodu = wuzidiaoduService.selectById(id);
		wuzidiaodu = wuzidiaoduService.selectView(new EntityWrapper<WuzidiaoduEntity>().eq("id", id));
        return R.ok().put("data", wuzidiaodu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WuzidiaoduEntity wuzidiaodu, HttpServletRequest request){
    	wuzidiaodu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wuzidiaodu);
        wuzidiaoduService.insert(wuzidiaodu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WuzidiaoduEntity wuzidiaodu, HttpServletRequest request){
    	wuzidiaodu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wuzidiaodu);
        wuzidiaoduService.insert(wuzidiaodu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WuzidiaoduEntity wuzidiaodu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wuzidiaodu);
        wuzidiaoduService.updateById(wuzidiaodu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wuzidiaoduService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
