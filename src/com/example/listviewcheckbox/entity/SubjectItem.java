package com.example.listviewcheckbox.entity;

/**
 * ������Ŀ��
 * @author zoupeiyang
 *
 */
public class SubjectItem {
	/**
	 * ����id
	 */
	private String subjectId;
	/**
	 * ��������
	 */
	private String subjectName;
	/**
	 * ����id
	 */
	private String itemId;
	/**
	 * ��������
	 */
	private String itemName;
	/**
	 * �Ƿ��ѡ
	 */
	private Boolean  isMultiChoice;
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Boolean getIsMultiChoice() {
		return isMultiChoice;
	}
	public void setIsMultiChoice(Boolean isMultiChoice) {
		this.isMultiChoice = isMultiChoice;
	}
	
	

}
