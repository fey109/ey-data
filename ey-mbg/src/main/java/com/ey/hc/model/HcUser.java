package com.ey.hc.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class HcUser implements Serializable {
    /**
     * 用户Id标识
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "用户Id标识")
    private Long id;

    /**
     * 用户登录名
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "用户登录名")
    private String username;

    /**
     * 用户登录密码
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "用户登录密码")
    private String password;

    /**
     * 用户状态  0-启用 1-禁用
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "用户状态  0-启用 1-禁用")
    private Integer status;

    /**
     * 创建时间
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    /**
     * 更新时间
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "更新时间")
    private Date updatetime;

    /**
     * 用户头像
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "用户头像")
    private String uImg;

    private String salt;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getuImg() {
        return uImg;
    }

    public void setuImg(String uImg) {
        this.uImg = uImg;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", uImg=").append(uImg);
        sb.append(", salt=").append(salt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}