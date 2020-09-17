package com.ey.hc.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class HcUserDetails implements Serializable {
    /**
     * Id标识
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "Id标识")
    private Long id;

    /**
     * 用户账号Id
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "用户账号Id")
    private Long uId;

    /**
     * 用户信息Id
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "用户信息Id")
    private Long userId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uId=").append(uId);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}