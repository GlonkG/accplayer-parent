package com.congee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: 小米粥
 * @description: com.congee.domain
 * @date: 2019/11/9
 * @time: 17:23
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "acc_money")
public class Money implements Serializable {

    //定义程序序列化ID.相当于身份认证，主要用于程序的版本控制，保持不同版本的兼容性。
    private static final long serialVersionUID = 1L;

    @Column(name = "user_id")
    private Integer uid;//用户id

    @Column(name = "user_mid")
    private String mid;//用户账户id

    @Column(name = "order_id")
    private String oid;//订单id

    @Column(name = "money_banlance")
    private Double mBanlance;//钱包余额

    @Column(name = "money_changetime")
    private Date mChangetime;//充值时间

    @Column(name = "money_charge")
    private Integer mCharge;//充值金额
}
