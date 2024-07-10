package com.entity.view;

import com.entity.GongzuoliangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 工作量
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("gongzuoliang")
public class GongzuoliangView extends GongzuoliangEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 xiangmu
			/**
			* 科研项目 的 教师
			*/
			private Integer xiangmuJiaoshiId;
			/**
			* 科研项目名称
			*/
			private String xiangmuName;
			/**
			* 科研项目类型
			*/
			private Integer xiangmuTypes;
				/**
				* 科研项目类型的值
				*/
				private String xiangmuValue;
			/**
			* 相关文件
			*/
			private String xiangmuFile;
			/**
			* 科研项目介绍
			*/
			private String xiangmuContent;
			/**
			* 逻辑删除
			*/
			private Integer xiangmuDelete;
			/**
			* 审核状态
			*/
			private Integer xiangmuYesnoTypes;
				/**
				* 审核状态的值
				*/
				private String xiangmuYesnoValue;
			/**
			* 审核意见
			*/
			private String xiangmuYesnoText;
			/**
			* 标准
			*/
			private String xiangmuTypesBeizhu;

	public GongzuoliangView() {

	}

	public GongzuoliangView(GongzuoliangEntity gongzuoliangEntity) {
		try {
			BeanUtils.copyProperties(this, gongzuoliangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

















				//级联表的get和set xiangmu
					/**
					* 获取：科研项目 的 教师
					*/
					public Integer getXiangmuJiaoshiId() {
						return xiangmuJiaoshiId;
					}
					/**
					* 设置：科研项目 的 教师
					*/
					public void setXiangmuJiaoshiId(Integer xiangmuJiaoshiId) {
						this.xiangmuJiaoshiId = xiangmuJiaoshiId;
					}

					/**
					* 获取： 科研项目名称
					*/
					public String getXiangmuName() {
						return xiangmuName;
					}
					/**
					* 设置： 科研项目名称
					*/
					public void setXiangmuName(String xiangmuName) {
						this.xiangmuName = xiangmuName;
					}
					/**
					* 获取： 科研项目类型
					*/
					public Integer getXiangmuTypes() {
						return xiangmuTypes;
					}
					/**
					* 设置： 科研项目类型
					*/
					public void setXiangmuTypes(Integer xiangmuTypes) {
						this.xiangmuTypes = xiangmuTypes;
					}


						/**
						* 获取： 科研项目类型的值
						*/
						public String getXiangmuValue() {
							return xiangmuValue;
						}
						/**
						* 设置： 科研项目类型的值
						*/
						public void setXiangmuValue(String xiangmuValue) {
							this.xiangmuValue = xiangmuValue;
						}
					/**
					* 获取： 相关文件
					*/
					public String getXiangmuFile() {
						return xiangmuFile;
					}
					/**
					* 设置： 相关文件
					*/
					public void setXiangmuFile(String xiangmuFile) {
						this.xiangmuFile = xiangmuFile;
					}
					/**
					* 获取： 科研项目介绍
					*/
					public String getXiangmuContent() {
						return xiangmuContent;
					}
					/**
					* 设置： 科研项目介绍
					*/
					public void setXiangmuContent(String xiangmuContent) {
						this.xiangmuContent = xiangmuContent;
					}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getXiangmuDelete() {
						return xiangmuDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setXiangmuDelete(Integer xiangmuDelete) {
						this.xiangmuDelete = xiangmuDelete;
					}
					/**
					* 获取： 审核状态
					*/
					public Integer getXiangmuYesnoTypes() {
						return xiangmuYesnoTypes;
					}
					/**
					* 设置： 审核状态
					*/
					public void setXiangmuYesnoTypes(Integer xiangmuYesnoTypes) {
						this.xiangmuYesnoTypes = xiangmuYesnoTypes;
					}


						/**
						* 获取： 审核状态的值
						*/
						public String getXiangmuYesnoValue() {
							return xiangmuYesnoValue;
						}
						/**
						* 设置： 审核状态的值
						*/
						public void setXiangmuYesnoValue(String xiangmuYesnoValue) {
							this.xiangmuYesnoValue = xiangmuYesnoValue;
						}
					/**
					* 获取： 审核意见
					*/
					public String getXiangmuYesnoText() {
						return xiangmuYesnoText;
					}
					/**
					* 设置： 审核意见
					*/
					public void setXiangmuYesnoText(String xiangmuYesnoText) {
						this.xiangmuYesnoText = xiangmuYesnoText;
					}

	public String getXiangmuTypesBeizhu() {
		return xiangmuTypesBeizhu;
	}

	public void setXiangmuTypesBeizhu(String xiangmuTypesBeizhu) {
		this.xiangmuTypesBeizhu = xiangmuTypesBeizhu;
	}
}
