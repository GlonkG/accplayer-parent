package com.congee.domain;

import lombok.Data;

/**
 * @author: 小米粥
 * @description: com.congee.domain
 * @date: 2019/11/20
 * @time: 22:17
 */
@Data
public class DeptSort {
    private String id;//编码
    private String name;//名称
    private String highDeptName;//上级部门
}
