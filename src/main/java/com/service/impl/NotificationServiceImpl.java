package com.service.impl;

import com.config.QuartzConfig;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.DTO.NotificationDTO;
import com.dao.NotificationDao;
import com.service.NotificationService;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Repository("NotificationService")
public class NotificationServiceImpl implements NotificationService {
	@Autowired
	NotificationDao notificationDao;

	@Autowired
	QuartzConfig quartzConfig;

	public int addNotification(NotificationDTO notify) throws SchedulerException, ParseException {
		notificationDao.addNotification(notify);
		return SchedulerNotify(notify);
	}

	private int SchedulerNotify(NotificationDTO notify) throws SchedulerException, ParseException {
		String sDate1 = notify.getScheduleDate();
		Date date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(sDate1);
		ScheduleBuilder<? extends Trigger> scheduleBuilder = simpleSchedule();
		TriggerBuilder<? extends Trigger> triggerBuilder = newTrigger().withSchedule(scheduleBuilder).startAt(date1);
		Trigger trigger = triggerBuilder.build();
		triggerBuilder.withIdentity("TestIdentity");
		JobDetail job = JobBuilder.newJob(NotificationJob.class).withIdentity("ScheduleMail", "group1")
				.usingJobData("id", notify.getId()).usingJobData("message", notify.getMessage())
				.usingJobData("notificationSub", notify.getNotificationSub())
				.usingJobData("emailId", notify.getEmailId()).build();
		// Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		Scheduler scheduler = quartzConfig.quartzScheduler().getScheduler();
		scheduler.clear();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
		return 0;
	}

	@Override
	public List<NotificationDTO> findAll() {

		return notificationDao.findAll();
	}

	@Override
	public int deleteNotification(String id) {
		Scheduler scheduler = quartzConfig.quartzScheduler().getScheduler();
		try {
			scheduler.clear();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notificationDao.deleteNotification(id);
		
	}
}
