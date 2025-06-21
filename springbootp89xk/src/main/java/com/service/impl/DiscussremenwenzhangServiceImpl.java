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


import com.dao.DiscussremenwenzhangDao;
import com.entity.DiscussremenwenzhangEntity;
import com.service.DiscussremenwenzhangService;
import com.entity.vo.DiscussremenwenzhangVO;
import com.entity.view.DiscussremenwenzhangView;

@Service("discussremenwenzhangService")
public class DiscussremenwenzhangServiceImpl extends ServiceImpl<DiscussremenwenzhangDao, DiscussremenwenzhangEntity> implements DiscussremenwenzhangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussremenwenzhangEntity> page = this.selectPage(
                new Query<DiscussremenwenzhangEntity>(params).getPage(),
                new EntityWrapper<DiscussremenwenzhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussremenwenzhangEntity> wrapper) {
		  Page<DiscussremenwenzhangView> page =new Query<DiscussremenwenzhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussremenwenzhangVO> selectListVO(Wrapper<DiscussremenwenzhangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussremenwenzhangVO selectVO(Wrapper<DiscussremenwenzhangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussremenwenzhangView> selectListView(Wrapper<DiscussremenwenzhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussremenwenzhangView selectView(Wrapper<DiscussremenwenzhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
