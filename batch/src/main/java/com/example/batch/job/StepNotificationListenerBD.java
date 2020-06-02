package com.example.batch.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class StepNotificationListenerBD extends StepExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(StepNotificationListenerBD.class);


	@Override
	public void beforeStep(StepExecution stepExecution) {
		 log.info("[StepNotificationListenerBD - beforeStep] Estado: "+ stepExecution.getStatus());
		super.beforeStep(stepExecution);
	}
	
	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		   log.info("[StepNotificationListenerBD - afterStep] Estado: "+ stepExecution.getStatus());
		return super.afterStep(stepExecution);
	}

}
