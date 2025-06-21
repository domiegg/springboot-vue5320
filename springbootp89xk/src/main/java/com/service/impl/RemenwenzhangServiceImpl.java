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


import com.dao.RemenwenzhangDao;
import com.entity.RemenwenzhangEntity;
import com.service.RemenwenzhangService;
import com.entity.vo.RemenwenzhangVO;
import com.entity.view.RemenwenzhangView;

@Service("remenwenzhangService")
public class RemenwenzhangServiceImpl extends ServiceImpl<RemenwenzhangDao, RemenwenzhangEntity> implements RemenwenzhangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RemenwenzhangEntity> page = this.selectPage(
                new Query<RemenwenzhangEntity>(params).getPage(),
                new EntityWrapper<RemenwenzhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RemenwenzhangEntity> wrapper) {
		  Page<RemenwenzhangView> page =new Query<RemenwenzhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<RemenwenzhangVO> selectListVO(Wrapper<RemenwenzhangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RemenwenzhangVO selectVO(Wrapper<RemenwenzhangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RemenwenzhangView> selectListView(Wrapper<RemenwenzhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RemenwenzhangView selectView(Wrapper<RemenwenzhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
