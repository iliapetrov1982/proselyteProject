package com.xometry.sonderlieferungen.rest;


import com.xometry.sonderlieferungen.model.Logistics;
import com.xometry.sonderlieferungen.service.LogisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */

@RestController
@RequestMapping("/api/v1/logistics")
public class LogisticsRestControllerV1 {

    private final LogisticsService logisticsService;

    public LogisticsRestControllerV1(LogisticsService logisticsService) {
        this.logisticsService = logisticsService;
    }

    @RequestMapping(value = "/sync", method = RequestMethod.GET)
    public void updateDb() {
        this.logisticsService.syncUp();
    }

    @GetMapping
    public ResponseEntity<List<Logistics>> getAllLogistics() {
        List<Logistics> logistics = this.logisticsService.getAll();
        if (logistics.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(logistics, HttpStatus.OK);
    }
}
