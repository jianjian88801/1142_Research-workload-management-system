package com.entity.model;

import com.entity.KeyanlunwenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 科研论文
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KeyanlunwenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 教师
     */
    private Integer jiaoshiId;


    /**
     * 科研论文名称
     */
    private String keyanlunwenName;


    /**
     * 科研论文类型
     */
    private Integer keyanlunwenTypes;


    /**
     * 相关文件
     */
    private String keyanlunwenFile;


    /**
     * 科研论文详情
     */
    private String keyanlunwenContent;


    /**
     * 逻辑删除
     */
    private Integer keyanlunwenDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 审核状态
     */
    private Integer keyanlunwenYesnoTypes;


    /**
     * 审核意见
     */
    private String keyanlunwenYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


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
	 * 获取：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：教师
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：科研论文名称
	 */
    public String getKeyanlunwenName() {
        return keyanlunwenName;
    }


    /**
	 * 设置：科研论文名称
	 */
    public void setKeyanlunwenName(String keyanlunwenName) {
        this.keyanlunwenName = keyanlunwenName;
    }
    /**
	 * 获取：科研论文类型
	 */
    public Integer getKeyanlunwenTypes() {
        return keyanlunwenTypes;
    }


    /**
	 * 设置：科研论文类型
	 */
    public void setKeyanlunwenTypes(Integer keyanlunwenTypes) {
        this.keyanlunwenTypes = keyanlunwenTypes;
    }
    /**
	 * 获取：相关文件
	 */
    public String getKeyanlunwenFile() {
        return keyanlunwenFile;
    }


    /**
	 * 设置：相关文件
	 */
    public void setKeyanlunwenFile(String keyanlunwenFile) {
        this.keyanlunwenFile = keyanlunwenFile;
    }
    /**
	 * 获取：科研论文详情
	 */
    public String getKeyanlunwenContent() {
        return keyanlunwenContent;
    }


    /**
	 * 设置：科研论文详情
	 */
    public void setKeyanlunwenContent(String keyanlunwenContent) {
        this.keyanlunwenContent = keyanlunwenContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getKeyanlunwenDelete() {
        return keyanlunwenDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setKeyanlunwenDelete(Integer keyanlunwenDelete) {
        this.keyanlunwenDelete = keyanlunwenDelete;
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
	 * 获取：审核状态
	 */
    public Integer getKeyanlunwenYesnoTypes() {
        return keyanlunwenYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setKeyanlunwenYesnoTypes(Integer keyanlunwenYesnoTypes) {
        this.keyanlunwenYesnoTypes = keyanlunwenYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getKeyanlunwenYesnoText() {
        return keyanlunwenYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setKeyanlunwenYesnoText(String keyanlunwenYesnoText) {
        this.keyanlunwenYesnoText = keyanlunwenYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
