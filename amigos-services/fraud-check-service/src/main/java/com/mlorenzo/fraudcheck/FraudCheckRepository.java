package com.mlorenzo.fraudcheck;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckRepository extends JpaRepository<FraudCheck, Integer> {
}
