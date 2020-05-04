package cn.itcast.order.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class XcOrders implements Serializable{
    private String orderNumber;

    private Float initialPrice;

    private Float price;

    private Date startTime;

    private Date endTime;

    private String status;

    private String userId;

    private String details;

    }