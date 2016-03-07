package com.xiezhaoxin.common.model;

public class InfoMgVO extends BaseVO {
	
	/**信息类型**/
	private String infoType;
	
	/**信息ID**/
	private String infoId;
	
	/**发布人ID**/
	private String publisherId;
	
	/**发布人姓名**/
	private String publisherName;
	
	/**发布时间**/
	private String publishDate;
	
	/**内容**/
	private String content;
	
	/**图片路径**/
	private String path;
	
	/**多媒体文件类型 0无音频视频 1音频 2视频**/
	private Character fileType;
	
	/**多媒体文件路径（只能单个）**/
	private String mediaPath;
	
	/**多媒体文件时长 单位秒**/
	private Integer mediaLenth;
	
	/**学校通知标题**/
	private String title;
	
	/**学校通知署名**/
	private String signature;
	
	/**作业的科目**/
	private String course;

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

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Character getFileType() {
		return fileType;
	}

	public void setFileType(Character fileType) {
		this.fileType = fileType;
	}

	public String getMediaPath() {
		return mediaPath;
	}

	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}

	public Integer getMediaLenth() {
		return mediaLenth;
	}

	public void setMediaLenth(Integer mediaLenth) {
		this.mediaLenth = mediaLenth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "InfoMgVO [infoType=" + infoType + ", infoId=" + infoId + ", publisherId=" + publisherId
				+ ", publisherName=" + publisherName + ", publishDate=" + publishDate + ", content=" + content
				+ ", path=" + path + ", fileType=" + fileType + ", mediaPath=" + mediaPath + ", mediaLenth="
				+ mediaLenth + ", title=" + title + ", signature=" + signature + ", course=" + course + "]";
	}
}
