package com.dao;

import com.entity.RemenwenzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RemenwenzhangVO;
import com.entity.view.RemenwenzhangView;


/**
 * 热门文章
 * 
 * @author 
 * @email 
 * @date 2022-04-27 19:40:43
 */
public interface RemenwenzhangDao extends BaseMapper<RemenwenzhangEntity> {
	
	List<RemenwenzhangVO> selectListVO(@Param("ew") Wrapper<RemenwenzhangEntity> wrapper);
	
	RemenwenzhangVO selectVO(@Param("ew") Wrapper<RemenwenzhangEntity> wrapper);
	
	List<RemenwenzhangView> selectListView(@Param("ew") Wrapper<RemenwenzhangEntity> wrapper);

	List<RemenwenzhangView> selectListView(Pagination page,@Param("ew") Wrapper<RemenwenzhangEntity> wrapper);
	
	RemenwenzhangView selectView(@Param("ew") Wrapper<RemenwenzhangEntity> wrapper);
	

}
