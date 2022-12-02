package main.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

@Slf4j
public class JobExecutionListener extends JobExecutionListenerSupport {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.debug("Init job "+jobExecution.getJobConfigurationName()+":"+jobExecution.getStatus());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
        }
    }
}
