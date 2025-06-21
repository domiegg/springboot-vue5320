package com.entity.view;

import com.entity.RemenwenzhangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 热门文章
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-27 19:40:43
 */
@TableName("remenwenzhang")
public class RemenwenzhangView  extends RemenwenzhangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public RemenwenzhangView(){
	}
 
 	public RemenwenzhangView(RemenwenzhangEntity remenwenzhangEntity){
 	try {
			BeanUtils.copyProperties(this, remenwenzhangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
