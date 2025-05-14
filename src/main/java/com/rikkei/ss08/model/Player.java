package com.rikkei.ss08.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Player {
    private int id;
    private String username;
    private String password;
    private String email;
    private double balance = 10000;
}
