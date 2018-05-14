package com.base.drest.domain;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "t_drest_param_info")
public class ParamInfo implements Serializable {
    @Column(name = "id")
    private String id;

    /**
     * 字典码
     */
    @Column(name = "code")
    private String code;

    /**
     * 字典名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 类别
     */
    @Column(name = "type")
    private String type;

    @Column(name = "parent_id")
    private String parentId;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取字典码
     *
     * @return code - 字典码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置字典码
     *
     * @param code 字典码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取字典名称
     *
     * @return name - 字典名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置字典名称
     *
     * @param name 字典名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取类别
     *
     * @return type - 类别
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类别
     *
     * @param type 类别
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return parent_id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}