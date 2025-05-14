package com.rikkei.ss08.service;

import com.rikkei.ss08.model.Seeds;
import com.rikkei.ss08.repository.SeedsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class SeedsService {
    @Autowired
    private SeedsRepository seedsRepository;

    public List<Seeds> getAllSeeds() {
        return seedsRepository.findAll();
    }
}
