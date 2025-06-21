package com.entity.view;

import com.entity.DiscusswenzhangfenxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 文章分享评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-27 19:40:43
 */
@TableName("discusswenzhangfenxiang")
public class DiscusswenzhangfenxiangView  extends DiscusswenzhangfenxiangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusswenzhangfenxiangView(){
	}
 
 	public DiscusswenzhangfenxiangView(DiscusswenzhangfenxiangEntity discusswenzhangfenxiangEntity){
 	try {
			BeanUtils.copyProperties(this, discusswenzhangfenxiangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
