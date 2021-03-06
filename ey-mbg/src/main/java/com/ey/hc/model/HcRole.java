package com.ey.hc.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class HcRole implements Serializable {
    /**
     * 角色id
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "角色id")
    private Long id;

    /**
     * 角色名称
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "角色名称")
    private String name;

    /**
     * 描述
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 创建时间
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 启用状态：0->禁用；1->启用
     *
     * @mbg.generated
    */
    @ApiModelProperty(value = "启用状态：0->禁用；1->启用")
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}