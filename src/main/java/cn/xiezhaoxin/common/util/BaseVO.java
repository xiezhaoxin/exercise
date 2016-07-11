package cn.xiezhaoxin.common.util;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.xiezhaoxin.common.util.properties.BasicFilterResult;
import cn.xiezhaoxin.common.util.properties.FilterSensitive;

public class BaseVO {
	private String id;
	private Date createDate;
	private char isDel;
	private Date deleteDate;

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

	public char getIsDel() {
		return isDel;
	}

	public void setIsDel(char isDel) {
		this.isDel = isDel;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	
	@JsonIgnore
	public boolean isNew() {
		return (this.id == null || this.id.length() == 0);
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseVO other = (BaseVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public String filterWords(String content){
		BasicFilterResult result = FilterSensitive.filterText(content, '*');
		return result.getFilteredContent();
	}

	@Override
	public String toString() {
		return "BaseVO [id=" + id + ", createDate=" + createDate + ", isDel="
				+ isDel + ", deleteDate=" + deleteDate + "]";
	}

}
