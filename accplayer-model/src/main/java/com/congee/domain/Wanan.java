package com.congee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: 小米粥
 * @description: com.congee.domain
 * @date: 2019/11/13
 * @time: 15:23
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wanan")
public class Wanan implements Serializable {
    //定义程序序列化ID.相当于身份认证，主要用于程序的版本控制，保持不同版本的兼容性。
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String pass;
    private String token;
}
