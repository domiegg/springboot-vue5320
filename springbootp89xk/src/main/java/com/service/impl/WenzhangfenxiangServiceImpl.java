package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.WenzhangfenxiangDao;
import com.entity.WenzhangfenxiangEntity;
import com.service.WenzhangfenxiangService;
import com.entity.vo.WenzhangfenxiangVO;
import com.entity.view.WenzhangfenxiangView;

@Service("wenzhangfenxiangService")
public class WenzhangfenxiangServiceImpl extends ServiceImpl<WenzhangfenxiangDao, WenzhangfenxiangEntity> implements WenzhangfenxiangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WenzhangfenxiangEntity> page = this.selectPage(
                new Query<WenzhangfenxiangEntity>(params).getPage(),
                new EntityWrapper<WenzhangfenxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WenzhangfenxiangEntity> wrapper) {
		  Page<WenzhangfenxiangView> page =new Query<WenzhangfenxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WenzhangfenxiangVO> selectListVO(Wrapper<WenzhangfenxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WenzhangfenxiangVO selectVO(Wrapper<WenzhangfenxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WenzhangfenxiangView> selectListView(Wrapper<WenzhangfenxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WenzhangfenxiangView selectView(Wrapper<WenzhangfenxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
