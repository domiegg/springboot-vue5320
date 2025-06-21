package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusswenzhangfenxiangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusswenzhangfenxiangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusswenzhangfenxiangView;


/**
 * 文章分享评论表
 *
 * @author 
 * @email 
 * @date 2022-04-27 19:40:43
 */
public interface DiscusswenzhangfenxiangService extends IService<DiscusswenzhangfenxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusswenzhangfenxiangVO> selectListVO(Wrapper<DiscusswenzhangfenxiangEntity> wrapper);
   	
   	DiscusswenzhangfenxiangVO selectVO(@Param("ew") Wrapper<DiscusswenzhangfenxiangEntity> wrapper);
   	
   	List<DiscusswenzhangfenxiangView> selectListView(Wrapper<DiscusswenzhangfenxiangEntity> wrapper);
   	
   	DiscusswenzhangfenxiangView selectView(@Param("ew") Wrapper<DiscusswenzhangfenxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusswenzhangfenxiangEntity> wrapper);
   	

}

