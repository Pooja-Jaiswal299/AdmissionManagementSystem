package com.app.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ams.model.Discount;

public interface DiscountRepository extends JpaRepository<Discount,Long> {}