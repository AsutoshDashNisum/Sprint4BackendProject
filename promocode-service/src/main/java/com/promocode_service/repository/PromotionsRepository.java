package com.promocode_service.repository;

import com.promocode_service.model.Promotions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionsRepository extends JpaRepository<Promotions, String> {
}
