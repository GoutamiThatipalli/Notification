package com.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.DTO.NotificationDTO;

public class NotifyRowMapper implements RowMapper<NotificationDTO> {
	@Override
	public NotificationDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NotificationDTO notify = new NotificationDTO();
		notify.setId(rs.getString("id"));
		notify.setNotificationName(rs.getString("notificationName"));
		notify.setMessage(rs.getString("message"));
		notify.setCreatedTime(rs.getString("createdTime"));
		notify.setScheduleDate(rs.getString("scheduleDate"));
		notify.setEmailId(rs.getString("emailId"));
		notify.setScheduleNow(rs.getString("scheduleNow"));
		return notify;
	}
}