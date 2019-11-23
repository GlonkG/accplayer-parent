package com.congee.domain;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDetail {
    private String orderNo;
    private Integer apid;
    private String userNickName;
    private String apic;
    private String gName;
    private Integer oAppointedtime;
    private double gPrice;//单价
    private double oMoney; //总钱数
    private Date oCreateTime;
    private Integer oStatus;

}
