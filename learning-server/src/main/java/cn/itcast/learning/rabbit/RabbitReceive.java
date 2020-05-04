package cn.itcast.learning.rabbit;

import cn.itcast.learning.config.LearningRabbitmqConfig;
import cn.itcast.learning.pojo.XcTask;
import cn.itcast.learning.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
@Slf4j
public class RabbitReceive {

    @Autowired
    private TaskService taskService;

    @Autowired
    private RabbitServer rabbitServer;

    @RabbitListener(queues = LearningRabbitmqConfig.XC_LEARNING_ADDCHOOSECOURSE)
    public void receiveAddCourse(XcTask xcTask){
        if (xcTask==null){
            throw new RuntimeException("xcTask is null");
        }
        log.info("receive add course:"+xcTask.getId());
        try {
            if (taskService.addCourse(xcTask)){
                rabbitServer.sendFinishedAddCourse(xcTask);
                log.info("send finished add course:"+xcTask.getId());
            }
        } catch (ParseException e) {
            log.error(e.getMessage(),e);
        }
    }
}
