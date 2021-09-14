package ga.hzcgw.springboot.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFirstJob implements Job {

    private final Logger logger = LoggerFactory.getLogger(MyFirstJob .class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info(
                jobExecutionContext.getTrigger().getKey().getName() + ": " +
                new SimpleDateFormat().format(new Date()) + "-->" + "Hello Spring Boot Quartz...");
    }
}
