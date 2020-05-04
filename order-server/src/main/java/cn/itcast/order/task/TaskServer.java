package cn.itcast.order.task;

import cn.itcast.order.pojo.XcTask;
import cn.itcast.order.pojo.XcTaskHis;
import cn.itcast.order.rabbit.RabbitServer;
import cn.itcast.order.service.XcTaskHisService;
import cn.itcast.order.service.XcTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TaskServer {

    @Autowired
    private RabbitServer rabbitServer;

    @Autowired
    private XcTaskService xcTaskService;

    @Autowired
    private XcTaskHisService xcTaskHisService;

    public static final int TASK_NUMBER = 1000;

    //每隔1分钟扫描消息表，向mq发送消息
    @Scheduled(fixedDelay = 60000)
    public void chooseCourseTask() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, -1);
        Date time = calendar.getTime();
        List<XcTask> xcTaskList = xcTaskService.findXcTaskBeforeUpdateTime(time, TASK_NUMBER);
        if (xcTaskList != null && xcTaskList.size() > 0) {
            for (XcTask xcTask : xcTaskList) {
                //调用乐观锁方法校验任务是否可以执行
                if (xcTaskService.updateTaskVersion(xcTask.getId(), xcTask.getVersion()) > 0) {
                    rabbitServer.sendAddCourse(xcTask);
                }
            }
        }
    }

    @Transactional
    public void finishedAddCourse(XcTask xcTask){
        XcTaskHis xcTaskHis=new XcTaskHis();
        BeanUtils.copyProperties(xcTask,xcTaskHis);
        xcTaskHisService.addXcTaskHis(xcTaskHis);
        xcTaskService.deleteTask(xcTask.getId());
    }

}
