package com.ey.hc.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class HcUserDetails implements Serializable {
    /**
     * 用户Id标识
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "用户Id标识")
    private Long userId;

    /**
     * 用户姓名
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "用户姓名")
    private String realName;

    /**
     * 性别 0-男 1-女
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "性别 0-男 1-女")
    private Integer sex;

    /**
     * 年龄
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 出生日期
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "出生日期")
    private Date birthday;

    /**
     * 身份证号
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "身份证号")
    private String idCard;

    /**
     * 民族
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "民族")
    private String nation;

    /**
     * 家庭地址
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "家庭地址")
    private String address;

    /**
     * 手机号码
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "手机号码")
    private Integer phone;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", realName=").append(realName);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(birthday);
        sb.append(", idCard=").append(idCard);
        sb.append(", nation=").append(nation);
        sb.append(", address=").append(address);
        sb.append(", phone=").append(phone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}