package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WenzhangfenxiangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WenzhangfenxiangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WenzhangfenxiangView;


/**
 * 文章分享
 *
 * @author 
 * @email 
 * @date 2022-04-27 19:40:43
 */
public interface WenzhangfenxiangService extends IService<WenzhangfenxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenzhangfenxiangVO> selectListVO(Wrapper<WenzhangfenxiangEntity> wrapper);
   	
   	WenzhangfenxiangVO selectVO(@Param("ew") Wrapper<WenzhangfenxiangEntity> wrapper);
   	
   	List<WenzhangfenxiangView> selectListView(Wrapper<WenzhangfenxiangEntity> wrapper);
   	
   	WenzhangfenxiangView selectView(@Param("ew") Wrapper<WenzhangfenxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenzhangfenxiangEntity> wrapper);
   	

}

