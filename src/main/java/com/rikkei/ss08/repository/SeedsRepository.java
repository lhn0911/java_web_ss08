package com.rikkei.ss08.repository;


import com.rikkei.ss08.model.Seeds;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
@Repository

public class SeedsRepository {
    public List<Seeds> findAll() {
        return Arrays.asList(
                new Seeds(1, "Hạt giống lúa", 500, "url1.jpg"),
                new Seeds(2, "Hạt giống ngô", 700, "url2.jpg"),
                new Seeds(3, "Hạt giống cà chua", 900, "url3.jpg")
        );
    }
}
