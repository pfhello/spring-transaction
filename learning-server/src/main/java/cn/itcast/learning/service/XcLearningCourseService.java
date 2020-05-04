package cn.itcast.learning.service;

import cn.itcast.learning.pojo.XcLearningCourse;

public interface XcLearningCourseService {

    XcLearningCourse findXcLearningCourseByUserIdAndCourseId(String userId,String courseId);

    int addXcLearningCourse(XcLearningCourse xcLearningCourse);

    int updateXcLearningCourse(XcLearningCourse xcLearningCourse);
}
