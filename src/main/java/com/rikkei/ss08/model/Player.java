package com.rikkei.ss08.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    private List<WarehouseSeeds> warehouse = new ArrayList<>();
    private List<FarmPlot> farm = new ArrayList<>();
}
