package com.app.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ams.model.Batch;

public interface BatchRepository extends JpaRepository<Batch,Long> {}
