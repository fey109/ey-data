package com.ey.hc.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class HcRolePermission implements Serializable {
    /**
     * id
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 角色id
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "角色id")
    private Long rId;

    /**
     * 权限id
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "权限id")
    private Long pId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", rId=").append(rId);
        sb.append(", pId=").append(pId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}