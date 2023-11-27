package com.example.ManyToManSpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ManyToManSpringBoot.Entity.Course;
import com.example.ManyToManSpringBoot.Entity.Student;
import com.example.ManyToManSpringBoot.Repository.CourseRepository;
import com.example.ManyToManSpringBoot.Repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository sRepo;

	@Autowired
	private CourseRepository cRepo;

	@GetMapping("/get")
	public List<Student> getALl() {
		return sRepo.findAll();
	}

	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		return sRepo.save(student);
	}

	@PostMapping("/post")
	public String addStudents(@RequestBody Student student) {
		sRepo.save(student);
		return "Added";
	}

	@GetMapping("/get/student/{name}")
	public List<Student> getNames(@PathVariable String name) {
		return sRepo.findByNameContaining(name);
	}

	@GetMapping("/get/course/{price}")
	public List<Course> getCourses(@PathVariable Long price) {
		return cRepo.findByPriceLessThan(price);
	}
}
