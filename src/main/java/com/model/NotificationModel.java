package com.model;

import java.io.Serializable;
import java.util.Date;
public class NotificationModel implements Serializable {
	private static final long serialVersionUID = 1L;	
	int id;
	String notificationName;
	String message;
	Date createdTime;
	Date scheduleDate;
	String emailId;
	int scheduleNow;
	String notificationSub;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNotificationName() {
		return notificationName;
	}
	public void setNotificationName(String notificationName) {
		this.notificationName = notificationName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getScheduleNow() {
		return scheduleNow;
	}
	public void setScheduleNow(int scheduleNow) {
		this.scheduleNow = scheduleNow;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNotificationSub() {
		return notificationSub;
	}
	public void setNotificationSub(String notificationSub) {
		this.notificationSub = notificationSub;
	}
	@Override
	public String toString() {
		return "NotificationModel [id=" + id + ", notificationName=" + notificationName + ", message=" + message
				+ ", createdTime=" + createdTime + ", scheduleDate=" + scheduleDate + ", emailId=" + emailId
				+ ", scheduleNow=" + scheduleNow + ", notificationSub=" + notificationSub + "]";
	}
	
	
}
