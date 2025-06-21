package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
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
import com.annotation.IgnoreAuth;

import com.entity.RemenwenzhangEntity;
import com.entity.view.RemenwenzhangView;

import com.service.RemenwenzhangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 热门文章
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-27 19:40:43
 */
@RestController
@RequestMapping("/remenwenzhang")
public class RemenwenzhangController {
    @Autowired
    private RemenwenzhangService remenwenzhangService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RemenwenzhangEntity remenwenzhang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			remenwenzhang.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<RemenwenzhangEntity> ew = new EntityWrapper<RemenwenzhangEntity>();
		PageUtils page = remenwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, remenwenzhang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RemenwenzhangEntity remenwenzhang, 
		HttpServletRequest request){
        EntityWrapper<RemenwenzhangEntity> ew = new EntityWrapper<RemenwenzhangEntity>();
		PageUtils page = remenwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, remenwenzhang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RemenwenzhangEntity remenwenzhang){
       	EntityWrapper<RemenwenzhangEntity> ew = new EntityWrapper<RemenwenzhangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( remenwenzhang, "remenwenzhang")); 
        return R.ok().put("data", remenwenzhangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RemenwenzhangEntity remenwenzhang){
        EntityWrapper< RemenwenzhangEntity> ew = new EntityWrapper< RemenwenzhangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( remenwenzhang, "remenwenzhang")); 
		RemenwenzhangView remenwenzhangView =  remenwenzhangService.selectView(ew);
		return R.ok("查询热门文章成功").put("data", remenwenzhangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RemenwenzhangEntity remenwenzhang = remenwenzhangService.selectById(id);
		remenwenzhang.setClicknum(remenwenzhang.getClicknum()+1);
		remenwenzhang.setClicktime(new Date());
		remenwenzhangService.updateById(remenwenzhang);
        return R.ok().put("data", remenwenzhang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RemenwenzhangEntity remenwenzhang = remenwenzhangService.selectById(id);
		remenwenzhang.setClicknum(remenwenzhang.getClicknum()+1);
		remenwenzhang.setClicktime(new Date());
		remenwenzhangService.updateById(remenwenzhang);
        return R.ok().put("data", remenwenzhang);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        RemenwenzhangEntity remenwenzhang = remenwenzhangService.selectById(id);
        if(type.equals("1")) {
        	remenwenzhang.setThumbsupnum(remenwenzhang.getThumbsupnum()+1);
        } else {
        	remenwenzhang.setCrazilynum(remenwenzhang.getCrazilynum()+1);
        }
        remenwenzhangService.updateById(remenwenzhang);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RemenwenzhangEntity remenwenzhang, HttpServletRequest request){
    	remenwenzhang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(remenwenzhang);
        remenwenzhangService.insert(remenwenzhang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RemenwenzhangEntity remenwenzhang, HttpServletRequest request){
    	remenwenzhang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(remenwenzhang);
        remenwenzhangService.insert(remenwenzhang);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RemenwenzhangEntity remenwenzhang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(remenwenzhang);
        remenwenzhangService.updateById(remenwenzhang);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        remenwenzhangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<RemenwenzhangEntity> wrapper = new EntityWrapper<RemenwenzhangEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = remenwenzhangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,RemenwenzhangEntity remenwenzhang, HttpServletRequest request,String pre){
        EntityWrapper<RemenwenzhangEntity> ew = new EntityWrapper<RemenwenzhangEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = remenwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, remenwenzhang), params), params));
        return R.ok().put("data", page);
    }







}
