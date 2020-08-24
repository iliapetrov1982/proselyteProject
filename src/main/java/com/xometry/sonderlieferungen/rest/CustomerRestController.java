package com.xometry.sonderlieferungen.rest;


import com.xometry.sonderlieferungen.initialdata.Data;
import com.xometry.sonderlieferungen.model.Logistics;
import com.xometry.sonderlieferungen.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */

@RestController
@RequestMapping("/data")
public class CustomerRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    Data data;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public void updateDb() {
        List<Logistics> customers = data.getDataFromFile();
        this.customerRepository.saveAll(customers);

    }

    @RequestMapping(value = "getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Logistics>> getAllCustomers() {
        List<Logistics> customers = (List<Logistics>) this.customerRepository.findAll();

        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
