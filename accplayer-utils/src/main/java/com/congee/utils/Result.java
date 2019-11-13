package com.congee.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: 小米粥
 * @description: com.congee.utils
 * @date: 2019/11/11
 * @time: 13:47
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    //状态码
    public Integer code;

    //响应信息
    public String message;

    //分页数据封装
    public List<T> list;

    //总记录数
    public long total;

}
