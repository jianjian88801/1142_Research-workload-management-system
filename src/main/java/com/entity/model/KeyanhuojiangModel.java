package com.entity.model;

import com.entity.KeyanhuojiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 科研获奖
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KeyanhuojiangModel implements Serializable {
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
     * 科研获奖名称
     */
    private String keyanhuojiangName;


    /**
     * 科研获奖类型
     */
    private Integer keyanhuojiangTypes;


    /**
     * 相关文件
     */
    private String keyanhuojiangFile;


    /**
     * 科研获奖详情
     */
    private String keyanhuojiangContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 审核状态
     */
    private Integer keyanhuojiangYesnoTypes;


    /**
     * 审核意见
     */
    private String keyanhuojiangYesnoText;


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
	 * 获取：科研获奖名称
	 */
    public String getKeyanhuojiangName() {
        return keyanhuojiangName;
    }


    /**
	 * 设置：科研获奖名称
	 */
    public void setKeyanhuojiangName(String keyanhuojiangName) {
        this.keyanhuojiangName = keyanhuojiangName;
    }
    /**
	 * 获取：科研获奖类型
	 */
    public Integer getKeyanhuojiangTypes() {
        return keyanhuojiangTypes;
    }


    /**
	 * 设置：科研获奖类型
	 */
    public void setKeyanhuojiangTypes(Integer keyanhuojiangTypes) {
        this.keyanhuojiangTypes = keyanhuojiangTypes;
    }
    /**
	 * 获取：相关文件
	 */
    public String getKeyanhuojiangFile() {
        return keyanhuojiangFile;
    }


    /**
	 * 设置：相关文件
	 */
    public void setKeyanhuojiangFile(String keyanhuojiangFile) {
        this.keyanhuojiangFile = keyanhuojiangFile;
    }
    /**
	 * 获取：科研获奖详情
	 */
    public String getKeyanhuojiangContent() {
        return keyanhuojiangContent;
    }


    /**
	 * 设置：科研获奖详情
	 */
    public void setKeyanhuojiangContent(String keyanhuojiangContent) {
        this.keyanhuojiangContent = keyanhuojiangContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getKeyanhuojiangYesnoTypes() {
        return keyanhuojiangYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setKeyanhuojiangYesnoTypes(Integer keyanhuojiangYesnoTypes) {
        this.keyanhuojiangYesnoTypes = keyanhuojiangYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getKeyanhuojiangYesnoText() {
        return keyanhuojiangYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setKeyanhuojiangYesnoText(String keyanhuojiangYesnoText) {
        this.keyanhuojiangYesnoText = keyanhuojiangYesnoText;
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
