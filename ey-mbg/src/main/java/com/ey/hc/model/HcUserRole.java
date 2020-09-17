package com.ey.hc.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class HcUserRole implements Serializable {
    /**
     * id标识
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "id标识")
    private Long id;

    /**
     * 用户id
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "用户id")
    private Long uId;

    /**
     * 角色id
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "角色id")
    private Long rId;

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

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uId=").append(uId);
        sb.append(", rId=").append(rId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}