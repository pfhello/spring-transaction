package cn.itcast.order.rabbit;

import cn.itcast.order.config.OrderRabbitmqConfig;
import cn.itcast.order.pojo.XcTask;
import cn.itcast.order.task.TaskServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitReceive {

    @Autowired
    private TaskServer taskServer;

    @RabbitListener(queues = OrderRabbitmqConfig.XC_LEARNING_FINISHADDCHOOSECOURSE)
    public void receiveFinishedAddCourse(XcTask xcTask){
        log.info("receive finished add course:"+xcTask.getId());
        taskServer.finishedAddCourse(xcTask);
    }
}
