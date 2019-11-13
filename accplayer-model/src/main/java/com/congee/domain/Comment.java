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
 * @time: 17:47
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "acc_comment")
public class Comment implements Serializable {

    //定义程序序列化ID.相当于身份认证，主要用于程序的版本控制，保持不同版本的兼容性。
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer cid;//评论id

    @Column(name = "user_id")
    private Integer uid;//用户id

    @Column(name = "accplayer_id")
    private Integer apid;//陪玩id

    @Column(name = "order_id")
    private String oid;//订单id

    @Column(name = "game_id")
    private Integer gid;//板块id

    @Column(name = "comment_context")
    private String cContext;//评论内容

    @Column(name = "comment_createtime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cCreatetime;//评论时间

    @Column(name = "comment_rank")
    private String cRank;//评分
}
