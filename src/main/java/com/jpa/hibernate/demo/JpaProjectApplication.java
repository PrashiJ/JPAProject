package com.jpa.hibernate.demo;

import com.jpa.hibernate.demo.entity.Course;
import com.jpa.hibernate.demo.repository.CourseRepository;
import com.jpa.hibernate.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaProjectApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository repository;
	@Autowired
	private StudentRepository studentRepository;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Course course = repository.findById(10001L);
		logger.info("Course 10001 ->{}", course);

		repository.deleteById(10001L);
		repository.save(new Course("Micro-services"));
	    repository.playingWithEntityManager();
		repository.findALL();
		studentRepository.saveStudentWithPassport();
	}

}
