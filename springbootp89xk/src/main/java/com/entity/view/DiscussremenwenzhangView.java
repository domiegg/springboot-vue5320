package com.entity.view;

import com.entity.DiscussremenwenzhangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 热门文章评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-27 19:40:43
 */
@TableName("discussremenwenzhang")
public class DiscussremenwenzhangView  extends DiscussremenwenzhangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussremenwenzhangView(){
	}
 
 	public DiscussremenwenzhangView(DiscussremenwenzhangEntity discussremenwenzhangEntity){
 	try {
			BeanUtils.copyProperties(this, discussremenwenzhangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
