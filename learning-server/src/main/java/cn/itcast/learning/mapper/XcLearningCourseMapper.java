package cn.itcast.learning.mapper;


import cn.itcast.learning.pojo.XcLearningCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XcLearningCourseMapper {

    List<XcLearningCourse> findXcLearningCourseByUserIdAndCourseId(@Param("userId") String userId,@Param("courseId") String courseId);

    int addXcLearningCourse(XcLearningCourse xcLearningCourse);

    int updateXcLearningCourse(XcLearningCourse xcLearningCourse);

}