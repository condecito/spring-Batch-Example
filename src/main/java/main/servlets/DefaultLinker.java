package main.servlets;

import org.slf4j.event.Level;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultLinker {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job processJob;


    public String executeJob() {
        UUID uuid = UUID.randomUUID();

        String message = "Batch job has been invoked" + uuid.toString();
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
        try {
            jobLauncher.run(processJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException e) {
            message = e.getMessage();
        } catch (JobRestartException e) {
            message = e.getMessage();
        } catch (JobInstanceAlreadyCompleteException e) {
            message = e.getMessage();
        } catch (JobParametersInvalidException e) {
            message = e.getMessage();
        }
        return message;
    }
}
