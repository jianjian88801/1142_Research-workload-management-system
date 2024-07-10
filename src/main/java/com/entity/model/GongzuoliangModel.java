package com.entity.model;

import com.entity.GongzuoliangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 工作量
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongzuoliangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 项目
     */
    private Integer xiangmuId;


    /**
     * 工作量详情
     */
    private String gongzuoliangContent;


    /**
     * 提交总数
     */
    private Integer tijiaozongshu;


    /**
     * 总工作量
     */
    private Integer zonggongzuoliang;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：项目
	 */
    public Integer getXiangmuId() {
        return xiangmuId;
    }


    /**
	 * 设置：项目
	 */
    public void setXiangmuId(Integer xiangmuId) {
        this.xiangmuId = xiangmuId;
    }
    /**
	 * 获取：工作量详情
	 */
    public String getGongzuoliangContent() {
        return gongzuoliangContent;
    }


    /**
	 * 设置：工作量详情
	 */
    public void setGongzuoliangContent(String gongzuoliangContent) {
        this.gongzuoliangContent = gongzuoliangContent;
    }
    /**
	 * 获取：提交总数
	 */
    public Integer getTijiaozongshu() {
        return tijiaozongshu;
    }


    /**
	 * 设置：提交总数
	 */
    public void setTijiaozongshu(Integer tijiaozongshu) {
        this.tijiaozongshu = tijiaozongshu;
    }
    /**
	 * 获取：总工作量
	 */
    public Integer getZonggongzuoliang() {
        return zonggongzuoliang;
    }


    /**
	 * 设置：总工作量
	 */
    public void setZonggongzuoliang(Integer zonggongzuoliang) {
        this.zonggongzuoliang = zonggongzuoliang;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
