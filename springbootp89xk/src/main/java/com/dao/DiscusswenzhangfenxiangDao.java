package com.dao;

import com.entity.DiscusswenzhangfenxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusswenzhangfenxiangVO;
import com.entity.view.DiscusswenzhangfenxiangView;


/**
 * 文章分享评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-27 19:40:43
 */
public interface DiscusswenzhangfenxiangDao extends BaseMapper<DiscusswenzhangfenxiangEntity> {
	
	List<DiscusswenzhangfenxiangVO> selectListVO(@Param("ew") Wrapper<DiscusswenzhangfenxiangEntity> wrapper);
	
	DiscusswenzhangfenxiangVO selectVO(@Param("ew") Wrapper<DiscusswenzhangfenxiangEntity> wrapper);
	
	List<DiscusswenzhangfenxiangView> selectListView(@Param("ew") Wrapper<DiscusswenzhangfenxiangEntity> wrapper);

	List<DiscusswenzhangfenxiangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusswenzhangfenxiangEntity> wrapper);
	
	DiscusswenzhangfenxiangView selectView(@Param("ew") Wrapper<DiscusswenzhangfenxiangEntity> wrapper);
	

}
