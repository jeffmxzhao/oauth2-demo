package com.kkl.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Long userId;
    private String username;
    private String password;
}
