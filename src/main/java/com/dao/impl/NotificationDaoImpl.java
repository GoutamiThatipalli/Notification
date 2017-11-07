package com.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.DTO.NotificationDTO;
import com.dao.NotificationDao;
import com.util.NotifyRowMapper;

@Repository("NotificationDao")
public class NotificationDaoImpl implements NotificationDao {
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	public int addNotification(NotificationDTO notify) {

		String query = "insert into schedule values(:id,:name,:message,:time,:date,:email,:scheduleNow,:subject)";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", notify.getId());
		map.put("name", notify.getNotificationName());
		map.put("message", notify.getMessage());
		map.put("time", notify.getCreatedTime());
		map.put("date", notify.getScheduleDate());
		map.put("email", notify.getEmailId());
		map.put("scheduleNow", notify.getScheduleNow());
		map.put("subject",notify.getNotificationSub());
		return jdbcTemplate.update(query, map);
	}

	public List<NotificationDTO> findAll() {
		String query = "select * from schedule";
		return jdbc.query(query, new NotifyRowMapper());
	}
	public int deleteNotification(String id) {
		String query = "delete from schedule where id=?";
		return jdbc.update(query,id);
		
	}

}
