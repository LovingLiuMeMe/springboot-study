package cn.lovingliu.rabbitmqproducer.config.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/**
 * @Author：LovingLiu
 * @Description: 定时任务的配置
 * @Date：Created in 2019-09-24
 */
@Configuration
@EnableScheduling
public class TaskSchedulerConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskScheduler());
    }
    /**
     * @Desc 指定100个任务线程 并注入容器
     * @Author LovingLiu
    */
    @Bean
    public Executor taskScheduler(){
        return Executors.newScheduledThreadPool(100);
    }

}
