package com.service;

import java.text.ParseException;
import java.util.List;

import org.quartz.SchedulerException;
import org.springframework.stereotype.Component;

import com.DTO.NotificationDTO;
@Component
public interface NotificationService {
	public int addNotification(NotificationDTO notify) throws SchedulerException, ParseException;
	public List<NotificationDTO> findAll();
	public int deleteNotification(String id);
}
