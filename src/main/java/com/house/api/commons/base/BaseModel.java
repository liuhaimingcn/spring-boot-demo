package com.house.api.commons.base;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Foghost
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseModel implements Serializable{

	private static final long serialVersionUID = 1034671331121855153L;

    /**
     * 主键
     */
	private String id;

    /**
     * 创建时间
     */
	private Date createdOn;

    /**
     * 更新时间
     */
	private Date updatedOn;

    /**
     * 1-正常0-删除，详见ConstantType:STATUS
     */
	private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
