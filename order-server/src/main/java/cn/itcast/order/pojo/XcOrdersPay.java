package cn.itcast.order.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class XcOrdersPay implements Serializable{
    private String id;

    private String orderNumber;

    private String payNumber;

    private String status;

    }