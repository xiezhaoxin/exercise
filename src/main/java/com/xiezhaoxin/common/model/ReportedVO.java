package com.xiezhaoxin.common.model;


public class ReportedVO extends BaseVO {
	
	/**举报类型   主题message 评论comment 问题question、回答answer、 作业homework、 学校通知schoolnotice、 班级通知clazznotice**/
	private String infoType;
	
	/**举报信息ID**/
	private String infoId;
	
	/**举报人Id 传学生或教师ID**/
	private String reportedUserId;
	
	/**举报人**/
	private String reportedUserName;
	
	/**举报时间**/
	private String reportedDate;
	
	/**举报次数**/
	private Integer reportedCount;
	
	/**举报原因**/
	private String reportedReason;
	
	public String getInfoType() {
		return infoType;
	}
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	public String getReportedUserId() {
		return reportedUserId;
	}
	public void setReportedUserId(String reportedUserId) {
		this.reportedUserId = reportedUserId;
	}
	public String getReportedUserName() {
		return reportedUserName;
	}
	public void setReportedUserName(String reportedUserName) {
		this.reportedUserName = reportedUserName;
	}
	public String getReportedDate() {
		return reportedDate;
	}
	public void setReportedDate(String reportedDate) {
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
	
	@Override
	public String toString() {
		return "ReportedVO [infoType=" + infoType + ", infoId=" + infoId + ", reportedUserId=" + reportedUserId
				+ ", reportedUserName=" + reportedUserName + ", reportedDate=" + reportedDate + ", reportedCount="
				+ reportedCount + ", reportedReason=" + reportedReason + "]";
	}
	
}
