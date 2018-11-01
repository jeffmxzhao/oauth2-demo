package com.kkl.demo.oauth2.server.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Long userId;
    private String username;
    private String password;
}
