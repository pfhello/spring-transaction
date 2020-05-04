package cn.itcast.order.mapper;


import cn.itcast.order.pojo.XcTask;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface XcTaskMapper {

    List<XcTask> findXcTaskBeforeUpdateTime(@Param("updateTime") Date updateTime,@Param("n") int n);

    int updateXcTaskTime(String id);

//    考虑订单服务将来会集群部署，为了避免任务在1分钟内重复执行，这里使用乐观锁，实现思路如下：
//            1) 每次取任务时判断当前版本及任务id是否匹配，如果匹配则执行任务，如果不匹配则取消执行。
//            2) 如果当前版本和任务Id可以匹配到任务则更新当前版本加1.
    int updateTaskVersion(@Param("id") String id,@Param("version") Integer version);

    int deleteTask(String id);
}