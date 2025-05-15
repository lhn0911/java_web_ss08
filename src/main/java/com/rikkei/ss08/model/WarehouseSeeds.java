package com.rikkei.ss08.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WarehouseSeeds {
    private int id;
    private int quantity;
    private Seeds seeds;
}
