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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNotification_name() {
		return notificationName;
	}
	public void setNotification_name(String notification_name) {
		this.notificationName = notification_name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated_time() {
		return createdTime;
	}
	public void setCreated_time(Date created_time) {
		this.createdTime = created_time;
	}
	public Date getSchedule_date() {
		return scheduleDate;
	}
	public void setSchedule_date(Date schedule_date) {
		this.scheduleDate = schedule_date;
	}
	public String getEmail_id() {
		return emailId;
	}
	public void setEmail_id(String email_id) {
		this.emailId = email_id;
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
	@Override
	public String toString() {
		return "NotificationModel [id=" + id + ", notification_name=" + notificationName + ", message=" + message
				+ ", created_time=" + createdTime + ", schedule_date=" + scheduleDate + ", email_id=" + emailId
				+ ", scheduleNow=" + scheduleNow + "]";
	}
	
}
