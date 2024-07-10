package com.entity.model;

import com.entity.MishuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 秘书
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MishuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 秘书工号
     */
    private String mishuUuidNumber;


    /**
     * 秘书姓名
     */
    private String mishuName;


    /**
     * 秘书手机号
     */
    private String mishuPhone;


    /**
     * 秘书头像
     */
    private String mishuPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String mishuEmail;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：秘书工号
	 */
    public String getMishuUuidNumber() {
        return mishuUuidNumber;
    }


    /**
	 * 设置：秘书工号
	 */
    public void setMishuUuidNumber(String mishuUuidNumber) {
        this.mishuUuidNumber = mishuUuidNumber;
    }
    /**
	 * 获取：秘书姓名
	 */
    public String getMishuName() {
        return mishuName;
    }


    /**
	 * 设置：秘书姓名
	 */
    public void setMishuName(String mishuName) {
        this.mishuName = mishuName;
    }
    /**
	 * 获取：秘书手机号
	 */
    public String getMishuPhone() {
        return mishuPhone;
    }


    /**
	 * 设置：秘书手机号
	 */
    public void setMishuPhone(String mishuPhone) {
        this.mishuPhone = mishuPhone;
    }
    /**
	 * 获取：秘书头像
	 */
    public String getMishuPhoto() {
        return mishuPhoto;
    }


    /**
	 * 设置：秘书头像
	 */
    public void setMishuPhoto(String mishuPhoto) {
        this.mishuPhoto = mishuPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getMishuEmail() {
        return mishuEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setMishuEmail(String mishuEmail) {
        this.mishuEmail = mishuEmail;
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
