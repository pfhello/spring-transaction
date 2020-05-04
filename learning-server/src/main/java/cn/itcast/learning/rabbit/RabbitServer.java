package cn.itcast.learning.rabbit;

import cn.itcast.learning.config.LearningRabbitmqConfig;
import cn.itcast.learning.pojo.XcTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class RabbitServer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendFinishedAddCourse(XcTask xcTask){
        log.info("send finished add course taskId:"+xcTask.getId());
        rabbitTemplate.convertAndSend(LearningRabbitmqConfig.EX_LEARNING_ADDCHOOSECOURSE,LearningRabbitmqConfig.XC_LEARNING_FINISHADDCHOOSECOURSE_KEY,xcTask);
    }
}
