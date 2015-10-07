package com.dtaliance.entry;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhf on 2015/9/17.
 */
public class SystemConfig implements Serializable{

    private static final long serialVersionUID = -1L;
    private String id;
    private String groupName;
    private String propertityName;
    private String propertityValue;
    private String envType;//开发：edv；测试：test；生产：pro
    private String createUser;
    private String updateUser;
    private Date createTime;
    private Date updateTime;

    private Long version;//乐观锁控制字段

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPropertityName() {
        return propertityName;
    }

    public void setPropertityName(String propertityName) {
        this.propertityName = propertityName;
    }

    public String getPropertityValue() {
        return propertityValue;
    }

    public void setPropertityValue(String propertityValue) {
        this.propertityValue = propertityValue;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    public String getEnvType() {
        return envType;
    }

    public void setEnvType(String envType) {
        this.envType = envType;
    }
}
