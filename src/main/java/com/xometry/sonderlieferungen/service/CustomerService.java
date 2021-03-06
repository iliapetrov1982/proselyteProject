package com.xometry.sonderlieferungen.service;

import com.xometry.sonderlieferungen.model.Logistics;

import java.util.List;

/**
 *
 */

public interface CustomerService {
    Logistics getById(Long id);
    void save(List<Logistics> dispatches);
    void delete (Long id);
    List<Logistics> getAll();
}
