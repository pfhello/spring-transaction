package cn.itcast.learning.service.impl;

import cn.itcast.learning.mapper.XcLearningCourseMapper;
import cn.itcast.learning.pojo.XcLearningCourse;
import cn.itcast.learning.service.XcLearningCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class XcLearningCourseServiceImpl implements XcLearningCourseService {

    @Autowired
    private XcLearningCourseMapper xcLearningCourseMapper;

    @Override
    public XcLearningCourse findXcLearningCourseByUserIdAndCourseId(String userId, String courseId) {
        List<XcLearningCourse> xcLearningCourseList = xcLearningCourseMapper.findXcLearningCourseByUserIdAndCourseId(userId, courseId);
        if (xcLearningCourseList!=null&&xcLearningCourseList.size()>0){
            return xcLearningCourseList.get(0);
        }
        return null;
    }

    @Transactional
    @Override
    public int addXcLearningCourse(XcLearningCourse xcLearningCourse) {
        return xcLearningCourseMapper.addXcLearningCourse(xcLearningCourse);
    }

    @Transactional
    @Override
    public int updateXcLearningCourse(XcLearningCourse xcLearningCourse) {
        return xcLearningCourseMapper.updateXcLearningCourse(xcLearningCourse);
    }
}
