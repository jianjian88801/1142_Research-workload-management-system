package com.entity.vo;

import com.entity.GongzuoliangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 工作量
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gongzuoliang")
public class GongzuoliangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
