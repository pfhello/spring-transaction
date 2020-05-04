package cn.itcast.learning.mapper;


import cn.itcast.learning.pojo.XcTaskHis;

public interface XcTaskHisMapper {

    XcTaskHis findXcTaskHisById(String id);

    int addXcTaskHis(XcTaskHis xcTaskHis);
}