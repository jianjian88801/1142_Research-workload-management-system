package com.entity.vo;

import com.entity.MishuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 秘书
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("mishu")
public class MishuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 秘书工号
     */

    @TableField(value = "mishu_uuid_number")
    private String mishuUuidNumber;


    /**
     * 秘书姓名
     */

    @TableField(value = "mishu_name")
    private String mishuName;


    /**
     * 秘书手机号
     */

    @TableField(value = "mishu_phone")
    private String mishuPhone;


    /**
     * 秘书头像
     */

    @TableField(value = "mishu_photo")
    private String mishuPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "mishu_email")
    private String mishuEmail;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：秘书工号
	 */
    public String getMishuUuidNumber() {
        return mishuUuidNumber;
    }


    /**
	 * 获取：秘书工号
	 */

    public void setMishuUuidNumber(String mishuUuidNumber) {
        this.mishuUuidNumber = mishuUuidNumber;
    }
    /**
	 * 设置：秘书姓名
	 */
    public String getMishuName() {
        return mishuName;
    }


    /**
	 * 获取：秘书姓名
	 */

    public void setMishuName(String mishuName) {
        this.mishuName = mishuName;
    }
    /**
	 * 设置：秘书手机号
	 */
    public String getMishuPhone() {
        return mishuPhone;
    }


    /**
	 * 获取：秘书手机号
	 */

    public void setMishuPhone(String mishuPhone) {
        this.mishuPhone = mishuPhone;
    }
    /**
	 * 设置：秘书头像
	 */
    public String getMishuPhoto() {
        return mishuPhoto;
    }


    /**
	 * 获取：秘书头像
	 */

    public void setMishuPhoto(String mishuPhoto) {
        this.mishuPhoto = mishuPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getMishuEmail() {
        return mishuEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setMishuEmail(String mishuEmail) {
        this.mishuEmail = mishuEmail;
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
