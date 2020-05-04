package cn.itcast.order.service.impl;

import cn.itcast.order.mapper.XcTaskHisMapper;
import cn.itcast.order.pojo.XcTaskHis;
import cn.itcast.order.service.XcTaskHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class XcTaskHisServiceImpl implements XcTaskHisService {

    @Autowired
    private XcTaskHisMapper xcTaskHisMapper;




    @Transactional
    @Override
    public int addXcTaskHis(XcTaskHis xcTaskHis) {
        return xcTaskHisMapper.addXcTaskHis(xcTaskHis);
    }
}
