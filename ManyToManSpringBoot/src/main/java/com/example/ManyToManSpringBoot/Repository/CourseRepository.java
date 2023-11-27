package com.example.ManyToManSpringBoot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ManyToManSpringBoot.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	public List<Course> findByPriceLessThan(Long price);
}
