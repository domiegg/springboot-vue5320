package com.dao;

import com.entity.DiscussremenwenzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussremenwenzhangVO;
import com.entity.view.DiscussremenwenzhangView;


/**
 * 热门文章评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-27 19:40:43
 */
public interface DiscussremenwenzhangDao extends BaseMapper<DiscussremenwenzhangEntity> {
	
	List<DiscussremenwenzhangVO> selectListVO(@Param("ew") Wrapper<DiscussremenwenzhangEntity> wrapper);
	
	DiscussremenwenzhangVO selectVO(@Param("ew") Wrapper<DiscussremenwenzhangEntity> wrapper);
	
	List<DiscussremenwenzhangView> selectListView(@Param("ew") Wrapper<DiscussremenwenzhangEntity> wrapper);

	List<DiscussremenwenzhangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussremenwenzhangEntity> wrapper);
	
	DiscussremenwenzhangView selectView(@Param("ew") Wrapper<DiscussremenwenzhangEntity> wrapper);
	

}
