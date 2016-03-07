package com.xiezhaoxin.common.util;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public class BaseBean implements Serializable {
	private static final long serialVersionUID = -7138575747606234262L;

	public final static char STATE_NORMAL = '0';
	public final static char STATE_DELETED = '1';
	@Id
	@Column(name = "PID", length = 32)
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid.hex")
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DELETE_DATE")
	private Date deleteDate;

	@Column(name = "ISDEL")
	private char isDel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public BaseBean() {
		super();
		createDate = new Date();
		isDel = STATE_NORMAL;
	}

	@JsonIgnore
	public boolean isNew() {
		return (this.id == null || this.id.length() == 0);
	}

	public char getIsDel() {
		return isDel;
	}

	@Transient
	public boolean isDel() {
		return STATE_DELETED == getIsDel();
	}

	public void setIsDel(char isDel) {
		this.isDel = isDel;
	}

	@Transient
	@JsonIgnore
	public void delete() {
		this.isDel = STATE_DELETED;
		this.deleteDate = new Date();
	}

	@Override
	public int hashCode() {
		if (isNew()) {
			return super.hashCode();
		}
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (isNew())
			return super.equals(obj);

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseBean other = (BaseBean) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseBean [id=" + id + ", createDate=" + createDate + ", deleteDate=" + deleteDate + ", isDel=" + isDel
				+ "]";
	}

}
