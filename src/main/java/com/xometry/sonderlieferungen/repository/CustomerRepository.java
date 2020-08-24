package com.xometry.sonderlieferungen.repository;


import com.xometry.sonderlieferungen.model.Logistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Logistics, Long> {

}
