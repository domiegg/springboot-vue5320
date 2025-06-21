package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussremenwenzhangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussremenwenzhangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussremenwenzhangView;


/**
 * 热门文章评论表
 *
 * @author 
 * @email 
 * @date 2022-04-27 19:40:43
 */
public interface DiscussremenwenzhangService extends IService<DiscussremenwenzhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussremenwenzhangVO> selectListVO(Wrapper<DiscussremenwenzhangEntity> wrapper);
   	
   	DiscussremenwenzhangVO selectVO(@Param("ew") Wrapper<DiscussremenwenzhangEntity> wrapper);
   	
   	List<DiscussremenwenzhangView> selectListView(Wrapper<DiscussremenwenzhangEntity> wrapper);
   	
   	DiscussremenwenzhangView selectView(@Param("ew") Wrapper<DiscussremenwenzhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussremenwenzhangEntity> wrapper);
   	

}

