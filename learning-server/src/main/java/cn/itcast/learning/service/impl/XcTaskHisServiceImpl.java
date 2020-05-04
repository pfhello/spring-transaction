package cn.itcast.learning.service.impl;

import cn.itcast.learning.mapper.XcTaskHisMapper;
import cn.itcast.learning.pojo.XcTaskHis;
import cn.itcast.learning.service.XcTaskHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class XcTaskHisServiceImpl implements XcTaskHisService {

    @Autowired
    private XcTaskHisMapper xcTaskHisMapper;


    @Override
    public XcTaskHis findXcTaskHisById(String id) {
        return xcTaskHisMapper.findXcTaskHisById(id);
    }


    @Transactional
    @Override
    public int addXcTaskHis(XcTaskHis xcTaskHis) {
        return xcTaskHisMapper.addXcTaskHis(xcTaskHis);
    }
}
