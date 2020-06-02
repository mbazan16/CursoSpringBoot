package com.example.batch.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class StepNotificationListener extends StepExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(StepNotificationListener.class);


	@Override
	public void beforeStep(StepExecution stepExecution) {
		 log.info("[StepNotificationListener - beforeStep] Estado: "+ stepExecution.getStatus());
		super.beforeStep(stepExecution);
	}
	
	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		   log.info("[StepNotificationListener - afterStep] Estado: "+ stepExecution.getStatus());
		return super.afterStep(stepExecution);
	}

}
