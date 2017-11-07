package com.dao;

import java.util.List;

import com.DTO.NotificationDTO;

public interface NotificationDao {
	public int addNotification(NotificationDTO notify);
	public List<NotificationDTO> findAll() ;
	public int deleteNotification(String id);
}
