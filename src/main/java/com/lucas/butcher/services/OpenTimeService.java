package com.lucas.butcher.services;

import com.lucas.butcher.repositories.OpenTimeRepository;
import org.springframework.stereotype.Service;

@Service
public class OpenTimeService {
    private final OpenTimeRepository openTimeRepository;

    public OpenTimeService(OpenTimeRepository openTimeRepository) {
        this.openTimeRepository = openTimeRepository;
    }
}
