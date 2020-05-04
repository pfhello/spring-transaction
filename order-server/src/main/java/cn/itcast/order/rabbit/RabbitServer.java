package cn.itcast.order.rabbit;

import cn.itcast.order.config.OrderRabbitmqConfig;
import cn.itcast.order.pojo.XcTask;
import cn.itcast.order.service.XcTaskService;
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

    @Autowired
    private XcTaskService xcTaskService;

    @Transactional
    public void sendAddCourse(XcTask xcTask){
        log.info("send add course taskId:"+xcTask.getId());
        rabbitTemplate.convertAndSend(OrderRabbitmqConfig.EX_LEARNING_ADDCHOOSECOURSE,OrderRabbitmqConfig.XC_LEARNING_ADDCHOOSECOURSE_KEY,xcTask);
        xcTaskService.updateXcTaskTime(xcTask.getId());
    }
}
