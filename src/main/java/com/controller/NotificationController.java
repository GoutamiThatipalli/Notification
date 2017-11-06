package com.controller;

import java.text.ParseException;
import java.util.List;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.DTO.NotificationDTO;
import com.service.NotificationService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "notifications")
public class NotificationController {
	@Autowired
	NotificationService notificationService;

	@RequestMapping(value = "addNotification", method = RequestMethod.POST, consumes = { "application/json" })
	public int addNotification(@RequestBody NotificationDTO notify) throws SchedulerException, ParseException {
		return notificationService.addNotification(notify);
	}
	@RequestMapping(value = "getAllNotifications")
	@Transactional(readOnly = true)
	public List<NotificationDTO> findAll() {
		return notificationService.findAll();
	}
	@RequestMapping(value = "deleteNotification/{id}", method = RequestMethod.DELETE)
	public int deleteNotification(@PathVariable String id) {
		return notificationService.deleteNotification(id);
	}

}
