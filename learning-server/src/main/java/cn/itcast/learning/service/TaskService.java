package cn.itcast.learning.service;

import cn.itcast.learning.pojo.XcLearningCourse;
import cn.itcast.learning.pojo.XcTask;
import cn.itcast.learning.pojo.XcTaskHis;
import cn.itcast.learning.util.JsonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class TaskService {

    @Autowired
    private XcLearningCourseService xcLearningCourseService;

    @Autowired
    private XcTaskHisService xcTaskHisService;

    @Transactional
    public boolean addCourse(XcTask xcTask) throws ParseException {
        String xcTaskId = xcTask.getId();
        if (xcTaskId==null){
            throw new RuntimeException("xcTaskId is null");
        }
        String json = xcTask.getRequestBody();
        Map map = JsonUtils.jsonToPojo(json, Map.class);
        String userId = (String) map.get("userId");
        if (userId==null){
            throw new RuntimeException("userId is null");
        }
        String courseId = (String) map.get("courseId");
        if (courseId==null){
            throw new RuntimeException("courseId is null");
        }
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTimeStr= (String) map.get("startTime");
        String endTimeStr= (String) map.get("endTime");
        Date startTime=null;
        Date endTime=null;
        if (!StringUtils.isEmpty(startTimeStr)) {
            startTime = format.parse(startTimeStr);
        }
        if (!StringUtils.isEmpty(endTimeStr)){
            endTime=format.parse(endTimeStr);
        }
        XcTaskHis xcTaskHis = xcTaskHisService.findXcTaskHisById(xcTaskId);
        if (xcTaskHis!=null){
            return true;
        }
        XcLearningCourse xcLearningCourse = xcLearningCourseService.findXcLearningCourseByUserIdAndCourseId(userId, courseId);
        if (xcLearningCourse==null){
            xcLearningCourse = new XcLearningCourse();
            xcLearningCourse.setUserId(userId);
            xcLearningCourse.setCourseId(courseId);
            xcLearningCourse.setStartTime(startTime);
            xcLearningCourse.setEndTime(endTime);
            xcLearningCourse.setStatus("501001");
            xcLearningCourseService.addXcLearningCourse(xcLearningCourse);
        }else {
            xcLearningCourse.setStartTime(startTime);
            xcLearningCourse.setEndTime(endTime);
            xcLearningCourse.setStatus("501001");
            xcLearningCourseService.updateXcLearningCourse(xcLearningCourse);
        }
        BeanUtils.copyProperties(xcTask,xcTaskHis);
        xcTaskHisService.addXcTaskHis(xcTaskHis);
        return true;
    }
}
