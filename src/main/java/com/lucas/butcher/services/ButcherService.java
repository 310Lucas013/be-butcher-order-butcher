package com.lucas.butcher.services;

import com.lucas.butcher.models.Butcher;
import com.lucas.butcher.repositories.ButcherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ButcherService {
    private final ButcherRepository butcherRepository;

    public ButcherService(ButcherRepository butcherRepository) {
        this.butcherRepository = butcherRepository;
    }

    public Butcher getButcherById(Long id) {
        return this.butcherRepository.getById(id);
    }

    public List<Butcher> getAllButchers() {
        return this.butcherRepository.findAll();
    }

}
