package com.congee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: 小米粥
 * @description: com.congee.domain
 * @date: 2019/11/9
 * @time: 17:14
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "acc_player")
public class Player implements Serializable {

    //定义程序序列化ID.相当于身份认证，主要用于程序的版本控制，保持不同版本的兼容性。
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Integer pid;//老板详情id

    @Column(name = "user_id")
    private Integer uid;//用户id

    @Column(name = "order_id")
    private String oid;//订单id

    @Column(name = "consume_id")
    private Integer cid;//消费id

    @Column(name = "consume_money")
    private Double cMoney;//消费金额

    @Column(name = "consume_createtime")
    private Date cCreatetime;//消费时间

}
