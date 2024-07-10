package com.entity.view;

import com.entity.KeyanlunwenEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 科研论文
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("keyanlunwen")
public class KeyanlunwenView extends KeyanlunwenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 科研论文类型的值
		*/
		private String keyanlunwenValue;
		/**
		* 审核状态的值
		*/
		private String keyanlunwenYesnoValue;



		//级联表 jiaoshi
			/**
			* 教师工号
			*/
			private String jiaoshiUuidNumber;
			/**
			* 教师姓名
			*/
			private String jiaoshiName;
			/**
			* 教师手机号
			*/
			private String jiaoshiPhone;
			/**
			* 教师身份证号
			*/
			private String jiaoshiIdNumber;
			/**
			* 教师头像
			*/
			private String jiaoshiPhoto;
			/**
			* 电子邮箱
			*/
			private String jiaoshiEmail;

	public KeyanlunwenView() {

	}

	public KeyanlunwenView(KeyanlunwenEntity keyanlunwenEntity) {
		try {
			BeanUtils.copyProperties(this, keyanlunwenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 科研论文类型的值
			*/
			public String getKeyanlunwenValue() {
				return keyanlunwenValue;
			}
			/**
			* 设置： 科研论文类型的值
			*/
			public void setKeyanlunwenValue(String keyanlunwenValue) {
				this.keyanlunwenValue = keyanlunwenValue;
			}
			/**
			* 获取： 审核状态的值
			*/
			public String getKeyanlunwenYesnoValue() {
				return keyanlunwenYesnoValue;
			}
			/**
			* 设置： 审核状态的值
			*/
			public void setKeyanlunwenYesnoValue(String keyanlunwenYesnoValue) {
				this.keyanlunwenYesnoValue = keyanlunwenYesnoValue;
			}
















				//级联表的get和set jiaoshi
					/**
					* 获取： 教师工号
					*/
					public String getJiaoshiUuidNumber() {
						return jiaoshiUuidNumber;
					}
					/**
					* 设置： 教师工号
					*/
					public void setJiaoshiUuidNumber(String jiaoshiUuidNumber) {
						this.jiaoshiUuidNumber = jiaoshiUuidNumber;
					}
					/**
					* 获取： 教师姓名
					*/
					public String getJiaoshiName() {
						return jiaoshiName;
					}
					/**
					* 设置： 教师姓名
					*/
					public void setJiaoshiName(String jiaoshiName) {
						this.jiaoshiName = jiaoshiName;
					}
					/**
					* 获取： 教师手机号
					*/
					public String getJiaoshiPhone() {
						return jiaoshiPhone;
					}
					/**
					* 设置： 教师手机号
					*/
					public void setJiaoshiPhone(String jiaoshiPhone) {
						this.jiaoshiPhone = jiaoshiPhone;
					}
					/**
					* 获取： 教师身份证号
					*/
					public String getJiaoshiIdNumber() {
						return jiaoshiIdNumber;
					}
					/**
					* 设置： 教师身份证号
					*/
					public void setJiaoshiIdNumber(String jiaoshiIdNumber) {
						this.jiaoshiIdNumber = jiaoshiIdNumber;
					}
					/**
					* 获取： 教师头像
					*/
					public String getJiaoshiPhoto() {
						return jiaoshiPhoto;
					}
					/**
					* 设置： 教师头像
					*/
					public void setJiaoshiPhoto(String jiaoshiPhoto) {
						this.jiaoshiPhoto = jiaoshiPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getJiaoshiEmail() {
						return jiaoshiEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setJiaoshiEmail(String jiaoshiEmail) {
						this.jiaoshiEmail = jiaoshiEmail;
					}


}
