package com.mars.elleshop.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author liujiulong
 * @date 2019/09/29  19:10:00
 */
@Getter
@Setter
public class User implements Serializable {

    private Integer uid;
    private String phone;
    private String username;
    private String password;
    private Double balance;

}
