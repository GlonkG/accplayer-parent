package com.congee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: 小米粥
 * @description: com.congee.domain
 * @date: 2019/11/9
 * @time: 17:36
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "acc_attention")
public class Attention{

    //定义程序序列化ID.相当于身份认证，主要用于程序的版本控制，保持不同版本的兼容性。
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attention_id")
    private Integer aid;//关注列表id

    @Column(name = "user_id")
    private Integer uid;//用户id

    @Column(name = "accplayer_id")
    private Integer apid;//陪玩id

    @Column(name = "attention_status")
    private Integer aStatus;//关注状态：默认 0关注 1拉黑
}
