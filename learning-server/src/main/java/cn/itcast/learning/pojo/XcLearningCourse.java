package cn.itcast.learning.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class XcLearningCourse implements Serializable{
    private String id;

    private String courseId;

    private String userId;

    private String charge;

    private Float price;

    private String valid;

    private Date startTime;

    private Date endTime;

    private String status;


}