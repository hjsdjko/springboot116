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

import com.cl.entity.DiaodujinduEntity;
import com.cl.entity.view.DiaodujinduView;

import com.cl.service.DiaodujinduService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 调度进度
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
@RestController
@RequestMapping("/diaodujindu")
public class DiaodujinduController {
    @Autowired
    private DiaodujinduService diaodujinduService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiaodujinduEntity diaodujindu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			diaodujindu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DiaodujinduEntity> ew = new EntityWrapper<DiaodujinduEntity>();

		PageUtils page = diaodujinduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diaodujindu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiaodujinduEntity diaodujindu, 
		HttpServletRequest request){
        EntityWrapper<DiaodujinduEntity> ew = new EntityWrapper<DiaodujinduEntity>();

		PageUtils page = diaodujinduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diaodujindu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiaodujinduEntity diaodujindu){
       	EntityWrapper<DiaodujinduEntity> ew = new EntityWrapper<DiaodujinduEntity>();
      	ew.allEq(MPUtil.allEQMapPre( diaodujindu, "diaodujindu")); 
        return R.ok().put("data", diaodujinduService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiaodujinduEntity diaodujindu){
        EntityWrapper< DiaodujinduEntity> ew = new EntityWrapper< DiaodujinduEntity>();
 		ew.allEq(MPUtil.allEQMapPre( diaodujindu, "diaodujindu")); 
		DiaodujinduView diaodujinduView =  diaodujinduService.selectView(ew);
		return R.ok("查询调度进度成功").put("data", diaodujinduView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiaodujinduEntity diaodujindu = diaodujinduService.selectById(id);
		diaodujindu = diaodujinduService.selectView(new EntityWrapper<DiaodujinduEntity>().eq("id", id));
        return R.ok().put("data", diaodujindu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiaodujinduEntity diaodujindu = diaodujinduService.selectById(id);
		diaodujindu = diaodujinduService.selectView(new EntityWrapper<DiaodujinduEntity>().eq("id", id));
        return R.ok().put("data", diaodujindu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiaodujinduEntity diaodujindu, HttpServletRequest request){
    	diaodujindu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(diaodujindu);
        diaodujinduService.insert(diaodujindu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiaodujinduEntity diaodujindu, HttpServletRequest request){
    	diaodujindu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(diaodujindu);
        diaodujinduService.insert(diaodujindu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiaodujinduEntity diaodujindu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(diaodujindu);
        diaodujinduService.updateById(diaodujindu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        diaodujinduService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
