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

import com.cl.entity.WuzixuqiuEntity;
import com.cl.entity.view.WuzixuqiuView;

import com.cl.service.WuzixuqiuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 物资需求
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
@RestController
@RequestMapping("/wuzixuqiu")
public class WuzixuqiuController {
    @Autowired
    private WuzixuqiuService wuzixuqiuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WuzixuqiuEntity wuzixuqiu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wuzixuqiu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WuzixuqiuEntity> ew = new EntityWrapper<WuzixuqiuEntity>();

		PageUtils page = wuzixuqiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wuzixuqiu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WuzixuqiuEntity wuzixuqiu, 
		HttpServletRequest request){
        EntityWrapper<WuzixuqiuEntity> ew = new EntityWrapper<WuzixuqiuEntity>();

		PageUtils page = wuzixuqiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wuzixuqiu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WuzixuqiuEntity wuzixuqiu){
       	EntityWrapper<WuzixuqiuEntity> ew = new EntityWrapper<WuzixuqiuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wuzixuqiu, "wuzixuqiu")); 
        return R.ok().put("data", wuzixuqiuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WuzixuqiuEntity wuzixuqiu){
        EntityWrapper< WuzixuqiuEntity> ew = new EntityWrapper< WuzixuqiuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wuzixuqiu, "wuzixuqiu")); 
		WuzixuqiuView wuzixuqiuView =  wuzixuqiuService.selectView(ew);
		return R.ok("查询物资需求成功").put("data", wuzixuqiuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WuzixuqiuEntity wuzixuqiu = wuzixuqiuService.selectById(id);
		wuzixuqiu = wuzixuqiuService.selectView(new EntityWrapper<WuzixuqiuEntity>().eq("id", id));
        return R.ok().put("data", wuzixuqiu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WuzixuqiuEntity wuzixuqiu = wuzixuqiuService.selectById(id);
		wuzixuqiu = wuzixuqiuService.selectView(new EntityWrapper<WuzixuqiuEntity>().eq("id", id));
        return R.ok().put("data", wuzixuqiu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WuzixuqiuEntity wuzixuqiu, HttpServletRequest request){
    	wuzixuqiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wuzixuqiu);
        wuzixuqiuService.insert(wuzixuqiu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WuzixuqiuEntity wuzixuqiu, HttpServletRequest request){
    	wuzixuqiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wuzixuqiu);
        wuzixuqiuService.insert(wuzixuqiu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WuzixuqiuEntity wuzixuqiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wuzixuqiu);
        wuzixuqiuService.updateById(wuzixuqiu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<WuzixuqiuEntity> list = new ArrayList<WuzixuqiuEntity>();
        for(Long id : ids) {
            WuzixuqiuEntity wuzixuqiu = wuzixuqiuService.selectById(id);
            wuzixuqiu.setSfsh(sfsh);
            wuzixuqiu.setShhf(shhf);
            list.add(wuzixuqiu);
        }
        wuzixuqiuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wuzixuqiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
