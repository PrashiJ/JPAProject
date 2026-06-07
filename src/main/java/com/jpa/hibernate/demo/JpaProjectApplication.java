package com.jpa.hibernate.demo;

import com.jpa.hibernate.demo.entity.*;
import com.jpa.hibernate.demo.repository.CourseRepository;
import com.jpa.hibernate.demo.repository.EmployeeRepository;
import com.jpa.hibernate.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaProjectApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		//List<Review> reviews = new ArrayList<>();
		//reviews.add(new Review("4", "Good to learn"));

//		Course course = repository.findById(10001L);
//		logger.info("Course 10001 ->{}", course);

//		repository.deleteById(10001L);
//		repository.save(new Course("Micro-services"));
	    //repository.playingWithEntityManager();
		//courseRepository.addHardCodedReviewsForCourse();
		//courseRepository.addReviewsForCourse(10003l, reviews);
		//studentRepository.insertStudentAndCourse(new Student("Jack"), new Course("Complete web-dev course"));
		employeeRepository.insert(new partTimeEmployee("Jill", new BigDecimal("50")));
		employeeRepository.insert(new fullTimeEmployee("Jack", new BigDecimal("15000")));

		logger.info("All Employees -> {}", employeeRepository.retrieveAllEmployees());


//		repository.findALL();
		//studentRepository.saveStudentWithPassport();
	}

}
