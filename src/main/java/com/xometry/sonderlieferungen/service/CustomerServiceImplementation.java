package com.xometry.sonderlieferungen.service;


import com.xometry.sonderlieferungen.initialdata.Data;
import com.xometry.sonderlieferungen.model.Logistics;
import com.xometry.sonderlieferungen.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Logistics getById(Long id) {
        return null;
    }

    @Override
    public void save(List<Logistics> dispatches) {
        customerRepository.saveAll(dispatches);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Logistics> getAll() {
        return null;
    }
}
