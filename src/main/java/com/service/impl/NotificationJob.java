package com.service.impl;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service("schedule")
public class NotificationJob implements Job {
    @Autowired
    public JavaMailSender sender; 
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
   
    	JobKey key = context.getJobDetail().getKey();

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String msg = dataMap.getString("message");
    	String mail=dataMap.getString("emailId");
    	String sub=dataMap.getString("notificationSub");
        try {
            sendEmail(mail,msg,sub);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Hello Quartz!");
    }

    private void sendEmail(String mail,String msg,String sub) throws Exception {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(mail);
        helper.setText(msg);
        helper.setSubject(sub);
        sender.send(message);
    }

}
