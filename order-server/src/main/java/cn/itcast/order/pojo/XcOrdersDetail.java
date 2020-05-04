package cn.itcast.order.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class XcOrdersDetail implements Serializable{
    private String id;

    private String orderNumber;

    private String itemId;

    private Integer itemNum;

    private Float itemPrice;

    private String valid;

    private Date startTime;

    private Date endTime;

    }