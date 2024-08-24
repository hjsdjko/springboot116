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

import com.cl.entity.DiaoduyuanEntity;
import com.cl.entity.view.DiaoduyuanView;

import com.cl.service.DiaoduyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 调度员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-30 16:06:31
 */
@RestController
@RequestMapping("/diaoduyuan")
public class DiaoduyuanController {
    @Autowired
    private DiaoduyuanService diaoduyuanService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		DiaoduyuanEntity u = diaoduyuanService.selectOne(new EntityWrapper<DiaoduyuanEntity>().eq("diaoduyuangonghao", username));
        if(u==null || !u.getDiaoduyuanmima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"diaoduyuan",  "管理员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody DiaoduyuanEntity diaoduyuan){
    	//ValidatorUtils.validateEntity(diaoduyuan);
    	DiaoduyuanEntity u = diaoduyuanService.selectOne(new EntityWrapper<DiaoduyuanEntity>().eq("diaoduyuangonghao", diaoduyuan.getDiaoduyuangonghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		diaoduyuan.setId(uId);
        diaoduyuanService.insert(diaoduyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        DiaoduyuanEntity u = diaoduyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	DiaoduyuanEntity u = diaoduyuanService.selectOne(new EntityWrapper<DiaoduyuanEntity>().eq("diaoduyuangonghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setDiaoduyuanmima("123456");
        diaoduyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiaoduyuanEntity diaoduyuan,
		HttpServletRequest request){
        EntityWrapper<DiaoduyuanEntity> ew = new EntityWrapper<DiaoduyuanEntity>();

		PageUtils page = diaoduyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diaoduyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiaoduyuanEntity diaoduyuan, 
		HttpServletRequest request){
        EntityWrapper<DiaoduyuanEntity> ew = new EntityWrapper<DiaoduyuanEntity>();

		PageUtils page = diaoduyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diaoduyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiaoduyuanEntity diaoduyuan){
       	EntityWrapper<DiaoduyuanEntity> ew = new EntityWrapper<DiaoduyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( diaoduyuan, "diaoduyuan")); 
        return R.ok().put("data", diaoduyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiaoduyuanEntity diaoduyuan){
        EntityWrapper< DiaoduyuanEntity> ew = new EntityWrapper< DiaoduyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( diaoduyuan, "diaoduyuan")); 
		DiaoduyuanView diaoduyuanView =  diaoduyuanService.selectView(ew);
		return R.ok("查询调度员成功").put("data", diaoduyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiaoduyuanEntity diaoduyuan = diaoduyuanService.selectById(id);
		diaoduyuan = diaoduyuanService.selectView(new EntityWrapper<DiaoduyuanEntity>().eq("id", id));
        return R.ok().put("data", diaoduyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiaoduyuanEntity diaoduyuan = diaoduyuanService.selectById(id);
		diaoduyuan = diaoduyuanService.selectView(new EntityWrapper<DiaoduyuanEntity>().eq("id", id));
        return R.ok().put("data", diaoduyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiaoduyuanEntity diaoduyuan, HttpServletRequest request){
    	diaoduyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(diaoduyuan);
    	DiaoduyuanEntity u = diaoduyuanService.selectOne(new EntityWrapper<DiaoduyuanEntity>().eq("diaoduyuangonghao", diaoduyuan.getDiaoduyuangonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		diaoduyuan.setId(new Date().getTime());
        diaoduyuanService.insert(diaoduyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiaoduyuanEntity diaoduyuan, HttpServletRequest request){
    	diaoduyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(diaoduyuan);
    	DiaoduyuanEntity u = diaoduyuanService.selectOne(new EntityWrapper<DiaoduyuanEntity>().eq("diaoduyuangonghao", diaoduyuan.getDiaoduyuangonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		diaoduyuan.setId(new Date().getTime());
        diaoduyuanService.insert(diaoduyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiaoduyuanEntity diaoduyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(diaoduyuan);
        diaoduyuanService.updateById(diaoduyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        diaoduyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
