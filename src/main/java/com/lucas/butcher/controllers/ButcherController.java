package com.lucas.butcher.controllers;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lucas.butcher.models.Butcher;
import com.lucas.butcher.models.HibernateProxyTypeAdapter;
import com.lucas.butcher.services.ButcherService;
import com.lucas.butcher.services.OpenTimeService;
import com.lucas.butcher.services.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/butchers")
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

    @GetMapping
    public ResponseEntity<String> getAllButchers() {
        System.out.println("Gets called");
        List<Butcher> butchers = butcherService.getAllButchers();
//        System.out.println(butchers);
//        System.out.println(butchers.toString());
        Gson gson = initiateGson();
        String result = gson.toJson(butchers);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<String> getButcherById(@PathVariable("id") Long id) {
        Butcher butcher = butcherService.getButcherById(id);
        Gson gson = initiateGson();
        String result = gson.toJson(butcher);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/credentials/{id}")
    public ResponseEntity<String> getButcherByCredentialId(@PathVariable("id") Long id) {
        System.out.println(id);
        Butcher butcher = butcherService.getButcherByCredentialId(id);
        Gson gson = initiateGson();
        String result = gson.toJson(butcher);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    private Gson initiateGson() {
        GsonBuilder b = new GsonBuilder();
        b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
                .excludeFieldsWithModifiers(Modifier.TRANSIENT)
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        boolean exclude = false;
                        try {
                            exclude = EXCLUDE.contains(f.getName());
                        } catch (Exception ignore) {
                        }
                        return exclude;
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                });
        return b.create();
    }

    private static final List<String> EXCLUDE = new ArrayList<>() {{
        add("butchers");
        add("butcher");
        add("schedule");
    }};
}
