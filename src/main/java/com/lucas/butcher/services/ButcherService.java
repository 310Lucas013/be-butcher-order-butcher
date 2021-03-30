package com.lucas.butcher.services;

import com.lucas.butcher.repositories.ButcherRepository;
import org.springframework.stereotype.Service;

@Service
public class ButcherService {
    private final ButcherRepository butcherRepository;

    public ButcherService(ButcherRepository butcherRepository) {
        this.butcherRepository = butcherRepository;
    }


}
