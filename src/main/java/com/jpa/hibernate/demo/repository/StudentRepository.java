package com.jpa.hibernate.demo.repository;

import com.jpa.hibernate.demo.entity.Course;
import com.jpa.hibernate.demo.entity.Passport;
import com.jpa.hibernate.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class StudentRepository {
    @Autowired
    EntityManager em;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Student findById(Long id){
        //return em.find(Student.class, id);
        TypedQuery<Student> query = em.createQuery("select c from Student c where c.id=:id", Student.class);
        return query.setParameter("id", id).getSingleResult();
    }

    public void deleteById(Long id){
        Student student = findById(id);
        em.remove(student);
    }

    public Student save(Student student) {
        if(student.getId() == null){
            em.persist(student);
        }
        else{
            em.merge(student);
        }
        return student;
    }

    public void playingWithEntityManager(){
        Student student1 = new Student("JUnit course");
         em.persist(student1);
        //em.flush();
        //em.detach(student1);
        student1.setName("Junit course - updated");
        logger.info("Student name:{}", student1);
        //em.clear();
//        em.refresh(student1);
        em.flush();
    }

    public void findALL(){
        TypedQuery<Student> query = em.createQuery("Select c from Student c", Student.class);
        List<Student> rs = query.getResultList();
        logger.info("List of Student-> {}", rs);
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport( "FSVH68369");
        em.persist(passport);
        Student student = new Student("Mike");
        student.setPassport(passport);
        em.persist(student);   // Passport will be persisted automatically
    }

    public void  insertStudentAndCourse(Student student, Course course){
        student.addCourse(course);
        course.addStudents(student);

        em.persist(student);
        em.persist(course);
    }

}
