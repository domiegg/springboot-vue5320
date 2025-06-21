package com.entity.view;

import com.entity.WenzhangfenxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 文章分享
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-27 19:40:43
 */
@TableName("wenzhangfenxiang")
public class WenzhangfenxiangView  extends WenzhangfenxiangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WenzhangfenxiangView(){
	}
 
 	public WenzhangfenxiangView(WenzhangfenxiangEntity wenzhangfenxiangEntity){
 	try {
			BeanUtils.copyProperties(this, wenzhangfenxiangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
