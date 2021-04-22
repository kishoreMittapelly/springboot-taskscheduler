package com.javainuse.taskconfig;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	
	@Autowired
	ReprocessService reprocessService;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"MM/dd/yyyy HH:mm:ss");

	

	@Scheduled(cron = "0 * * ? * *")
	public void performTaskUsingCron() {
		reprocessService.invokeReprocessAPI();
		System.out.println("Regular task performed using Cron at "
				+ dateFormat.format(new Date()));

	}
}
