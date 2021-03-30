package com.lucas.butcher.controllers;

import com.lucas.butcher.services.ButcherService;
import com.lucas.butcher.services.OpenTimeService;
import com.lucas.butcher.services.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = {"http://localhost:6001"})
public class ButcherController {
    private final ButcherService butcherService;
    private final OpenTimeService openTimeService;
    private final ScheduleService scheduleService;

    public ButcherController(ButcherService butcherService,
                             OpenTimeService openTimeService,
                             ScheduleService scheduleService) {
        this.butcherService = butcherService;
        this.openTimeService = openTimeService;
        this.scheduleService = scheduleService;
    }
}