package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 工作量
 *
 * @author 
 * @email
 */
@TableName("gongzuoliang")
public class GongzuoliangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongzuoliangEntity() {

	}

	public GongzuoliangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 项目
     */
    @TableField(value = "xiangmu_id")

    private Integer xiangmuId;


    /**
     * 工作量详情
     */
    @TableField(value = "gongzuoliang_content")

    private String gongzuoliangContent;


    /**
     * 提交总数
     */
    @TableField(value = "tijiaozongshu")

    private Integer tijiaozongshu;


    /**
     * 总工作量
     */
    @TableField(value = "zonggongzuoliang")

    private Integer zonggongzuoliang;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：项目
	 */
    public Integer getXiangmuId() {
        return xiangmuId;
    }


    /**
	 * 获取：项目
	 */

    public void setXiangmuId(Integer xiangmuId) {
        this.xiangmuId = xiangmuId;
    }
    /**
	 * 设置：工作量详情
	 */
    public String getGongzuoliangContent() {
        return gongzuoliangContent;
    }


    /**
	 * 获取：工作量详情
	 */

    public void setGongzuoliangContent(String gongzuoliangContent) {
        this.gongzuoliangContent = gongzuoliangContent;
    }
    /**
	 * 设置：提交总数
	 */
    public Integer getTijiaozongshu() {
        return tijiaozongshu;
    }


    /**
	 * 获取：提交总数
	 */

    public void setTijiaozongshu(Integer tijiaozongshu) {
        this.tijiaozongshu = tijiaozongshu;
    }
    /**
	 * 设置：总工作量
	 */
    public Integer getZonggongzuoliang() {
        return zonggongzuoliang;
    }


    /**
	 * 获取：总工作量
	 */

    public void setZonggongzuoliang(Integer zonggongzuoliang) {
        this.zonggongzuoliang = zonggongzuoliang;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Gongzuoliang{" +
            "id=" + id +
            ", xiangmuId=" + xiangmuId +
            ", gongzuoliangContent=" + gongzuoliangContent +
            ", tijiaozongshu=" + tijiaozongshu +
            ", zonggongzuoliang=" + zonggongzuoliang +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
