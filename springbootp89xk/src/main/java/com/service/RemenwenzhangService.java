package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RemenwenzhangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.RemenwenzhangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.RemenwenzhangView;


/**
 * 热门文章
 *
 * @author 
 * @email 
 * @date 2022-04-27 19:40:43
 */
public interface RemenwenzhangService extends IService<RemenwenzhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RemenwenzhangVO> selectListVO(Wrapper<RemenwenzhangEntity> wrapper);
   	
   	RemenwenzhangVO selectVO(@Param("ew") Wrapper<RemenwenzhangEntity> wrapper);
   	
   	List<RemenwenzhangView> selectListView(Wrapper<RemenwenzhangEntity> wrapper);
   	
   	RemenwenzhangView selectView(@Param("ew") Wrapper<RemenwenzhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RemenwenzhangEntity> wrapper);
   	

}

