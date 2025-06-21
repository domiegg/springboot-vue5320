package com.dao;

import com.entity.WenzhangfenxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WenzhangfenxiangVO;
import com.entity.view.WenzhangfenxiangView;


/**
 * 文章分享
 * 
 * @author 
 * @email 
 * @date 2022-04-27 19:40:43
 */
public interface WenzhangfenxiangDao extends BaseMapper<WenzhangfenxiangEntity> {
	
	List<WenzhangfenxiangVO> selectListVO(@Param("ew") Wrapper<WenzhangfenxiangEntity> wrapper);
	
	WenzhangfenxiangVO selectVO(@Param("ew") Wrapper<WenzhangfenxiangEntity> wrapper);
	
	List<WenzhangfenxiangView> selectListView(@Param("ew") Wrapper<WenzhangfenxiangEntity> wrapper);

	List<WenzhangfenxiangView> selectListView(Pagination page,@Param("ew") Wrapper<WenzhangfenxiangEntity> wrapper);
	
	WenzhangfenxiangView selectView(@Param("ew") Wrapper<WenzhangfenxiangEntity> wrapper);
	

}
