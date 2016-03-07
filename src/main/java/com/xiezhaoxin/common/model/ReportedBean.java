package com.xiezhaoxin.common.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class ReportedBean extends BaseBean {

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = 1L;
	
	/**信息类型**/
	@Column(name="INFO_TYPE",length=32)
	private String infoType;
	
	/**信息ID**/
	@Column(name="INFO_ID",length=32)
	private String infoId;
	
	/**举报时间**/
	@Column(name="REPORTED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reportedDate;
	
	/**举报次数**/
	@Column(name="REPORTED_COUNT")
	private Integer reportedCount;
	
	/**举报原因**/
	@Column(name="REPORTED_REASON")
	private String reportedReason;

	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	public Date getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}

	public Integer getReportedCount() {
		return reportedCount;
	}

	public void setReportedCount(Integer reportedCount) {
		this.reportedCount = reportedCount;
	}

	public String getReportedReason() {
		return reportedReason;
	}

	public void setReportedReason(String reportedReason) {
		this.reportedReason = reportedReason;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	@Override
	public String toString() {
		return "ReportedBean [infoType=" + infoType + ", infoId=" + infoId + ", reportedDate=" + reportedDate
				+ ", reportedCount=" + reportedCount + ", reportedReason=" + reportedReason + "]";
	}

}
