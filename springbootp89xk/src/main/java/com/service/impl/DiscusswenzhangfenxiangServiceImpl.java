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


import com.dao.DiscusswenzhangfenxiangDao;
import com.entity.DiscusswenzhangfenxiangEntity;
import com.service.DiscusswenzhangfenxiangService;
import com.entity.vo.DiscusswenzhangfenxiangVO;
import com.entity.view.DiscusswenzhangfenxiangView;

@Service("discusswenzhangfenxiangService")
public class DiscusswenzhangfenxiangServiceImpl extends ServiceImpl<DiscusswenzhangfenxiangDao, DiscusswenzhangfenxiangEntity> implements DiscusswenzhangfenxiangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusswenzhangfenxiangEntity> page = this.selectPage(
                new Query<DiscusswenzhangfenxiangEntity>(params).getPage(),
                new EntityWrapper<DiscusswenzhangfenxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusswenzhangfenxiangEntity> wrapper) {
		  Page<DiscusswenzhangfenxiangView> page =new Query<DiscusswenzhangfenxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusswenzhangfenxiangVO> selectListVO(Wrapper<DiscusswenzhangfenxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusswenzhangfenxiangVO selectVO(Wrapper<DiscusswenzhangfenxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusswenzhangfenxiangView> selectListView(Wrapper<DiscusswenzhangfenxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusswenzhangfenxiangView selectView(Wrapper<DiscusswenzhangfenxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
