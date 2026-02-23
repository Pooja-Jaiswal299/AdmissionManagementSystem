package com.app.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ams.model.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
	
}
