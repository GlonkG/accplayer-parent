package com.congee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: 小米粥
 * @description: com.congee.domain
 * @date: 2019/11/9
 * @time: 17:28
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "acc_order")
public class Order implements Serializable {

    //定义程序序列化ID.相当于身份认证，主要用于程序的版本控制，保持不同版本的兼容性。
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer oid;//订单id

    @Column(name = "order_no")
    private String orderNo;//订单流水id==订单编号

    @Column(name = "accplayer_id")
    private Integer apid;//陪玩id

    @Column(name = "user_nickname")
    private String userNickname;//昵称

    @Column(name = "game_id")
    private Integer gid;//板块id=服务id

    @Column(name = "game_name")
    private String gName;//板块名称=服务类型

    @Column(name = "order_appointedtime")
    private Integer oAppointedtime;//约定时长

    @Column(name = "order_content")
    private String oContent;//订单留言

    @Column(name = "order_money")
    private Double oMoney;//订单金额

    @Column(name = "order_createtime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date oCreatetime;//订单创建时间

    @Column(name = "order_status")
    private Integer oStatus;//订单状态

    @Column(name = "user_tel")
    private String userTel;//电话号码

    @Column(name = "user_qq")
    private String userQq;//QQ
}
