package com.DTO;

public class NotificationDTO {
    String id;
    String notificationName;
    String message;
    String createdTime;
    String scheduleDate;
    String emailId;
    String scheduleNow;
    String notificationSub;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  String getNotificationName() {
        return notificationName;
    }

    public String getNotificationSub() {
		return notificationSub;
	}

	public void setNotificationSub(String notificationSub) {
		this.notificationSub = notificationSub;
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

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getScheduleNow() {
        return scheduleNow;
    }

    public void setScheduleNow(String scheduleNow) {
        this.scheduleNow = scheduleNow;
    }
}
