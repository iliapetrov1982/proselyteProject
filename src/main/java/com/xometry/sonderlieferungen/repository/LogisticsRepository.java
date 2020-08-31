package com.xometry.sonderlieferungen.repository;

import com.xometry.sonderlieferungen.model.Logistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticsRepository extends JpaRepository<Logistics, Long> {
    Logistics findByOrderNumber(String orderNumber);
}
