package cn.itcast.order.service.impl;

import cn.itcast.order.mapper.XcTaskMapper;
import cn.itcast.order.pojo.XcTask;
import cn.itcast.order.service.XcTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class XcTaskServiceImpl implements XcTaskService {

    @Autowired
    private XcTaskMapper xcTaskMapper;

    @Override
    public List<XcTask> findXcTaskBeforeUpdateTime(Date updateTime, int n) {
        return xcTaskMapper.findXcTaskBeforeUpdateTime(updateTime,n);
    }

    @Transactional
    @Override
    public int updateXcTaskTime(String id) {
        return xcTaskMapper.updateXcTaskTime(id);
    }

    @Transactional
    @Override
    public int updateTaskVersion(String id, Integer version) {
        return xcTaskMapper.updateTaskVersion(id,version);
    }

    @Transactional
    @Override
    public int deleteTask(String id) {
        return xcTaskMapper.deleteTask(id);
    }
}
