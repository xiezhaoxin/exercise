package cn.xiezhaoxin.common.util;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class InfoMgBean extends BaseBean {

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = 7745461378725299570L;
	
	/**信息类型**/
	@Column(name="INFO_TYPE",length=32)
	private String infoType;
	
	/**信息ID**/
	@Column(name="INFO_ID",length=32)
	private String infoId;
	
	/**内容**/
	@Column(name="INFO_CONTENT",length=1000)
	private String content;
	
	/**多媒体文件类型 0无音频视频 1音频 2视频**/
	@Column(name="INFO_FILETYPE",length=40)
	private Character fileType;
    
	/**多媒体文件时长 单位秒**/
	@Column(name="INFO_MEDIALENTH",length=2)
	private Integer mediaLenth;
	
	/**学校通知标题**/
	@Column(name="INFO_TITLE",length=50)
	private String title;
	
	/**学校通知署名**/
	@Column(name="INFO_SIGNATURE",length=500)
	private String signature;
	
	/** 作业所属科目名 **/
	@Column(name = "INFO_COURSE", length = 32)
	private String course;
	
	/**图片路径**/
	@Column(name="INFO_PATH",length=500)
	private String path;
	
	/**多媒体文件路径（只能单个）**/
	@Column(name="INFO_MEDIAPATH",length=40)
	private String mediaPath;
	

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Character getFileType() {
		return fileType;
	}

	public void setFileType(Character fileType) {
		this.fileType = fileType;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMediaPath() {
		return mediaPath;
	}

	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}

	@Override
	public String toString() {
		return "InfoMgBean [infoType=" + infoType + ", infoId=" + infoId + ", content=" + content + ", fileType="
				+ fileType + ", mediaLenth=" + mediaLenth + ", title=" + title + ", signature=" + signature
				+ ", course=" + course + ", path=" + path + ", mediaPath=" + mediaPath + "]";
	}
	
}
