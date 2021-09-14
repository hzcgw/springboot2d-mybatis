package ga.hzcgw.springboot.config;

/*@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail1() {
        return JobBuilder.newJob(MyFirstJob.class).storeDurably().build();
    }

    @Bean
    public Trigger trigger1() {
        SimpleScheduleBuilder simpleScheduleBuilder =
                SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(1);

        return TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(simpleScheduleBuilder)
                .forJob(jobDetail1())
                .build();
    }

    @Bean
    public Trigger trigger2() {
        return TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? *"))
                .forJob(jobDetail1())
                .build();
    }

}*/
