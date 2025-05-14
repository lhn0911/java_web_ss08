package com.rikkei.ss08.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Seeds {
    private int id;
    private String seedsName;
    private double price;
    private String imageUrl;
}
