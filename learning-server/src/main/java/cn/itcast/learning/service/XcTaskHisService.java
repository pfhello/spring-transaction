package cn.itcast.learning.service;

import cn.itcast.learning.pojo.XcTaskHis;

public interface XcTaskHisService {

    XcTaskHis findXcTaskHisById(String id);

    int addXcTaskHis(XcTaskHis xcTaskHis);
}
