package cn.itcast.order.service;

import cn.itcast.order.pojo.XcTask;

import java.util.Date;
import java.util.List;

public interface XcTaskService {

    List<XcTask> findXcTaskBeforeUpdateTime(Date updateTime, int n);

    int updateXcTaskTime(String id);

    int updateTaskVersion(String id,Integer version);

    int deleteTask(String id);
}
