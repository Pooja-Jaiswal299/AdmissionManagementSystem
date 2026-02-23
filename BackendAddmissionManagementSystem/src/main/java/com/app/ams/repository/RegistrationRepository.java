package com.app.ams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ams.model.Registration;
import com.app.ams.model.User;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    List<Registration> findByStudent(User user);
}
