package com.jpa.hibernate.demo.repository;

import com.jpa.hibernate.demo.entity.Course;
import com.jpa.hibernate.demo.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseRepository {
    @Autowired
    EntityManager em;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Course findById(Long id){
        //return em.find(Course.class, id);
        TypedQuery<Course> query = em.createQuery("select c from Course c where c.id=:id", Course.class);
        return query.setParameter("id", id).getSingleResult();
    }

    public void deleteById(Long id){
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course) {
        if(course.getId() == null){
            em.persist(course);
        }
        else{
            em.merge(course);
        }
        return course;
    }

    public void playingWithEntityManager(){
        Course course1 = new Course("JUnit course");
         em.persist(course1);
        //em.flush();
        //em.detach(course1);
        course1.setName("Junit course - updated");
        logger.info("Course name:{}", course1);
        //em.clear();
//        em.refresh(course1);
        em.flush();
    }

    public void findALL(){
        TypedQuery<Course> query = em.createQuery("Select c from Course c", Course.class);
        List<Course> rs = query.getResultList();
        logger.info("List of Course-> {}", rs);
    }

    public void addHardCodedReviewsForCourse(){
        Course course = findById(10001l);
        Review review = new Review("5", "Great Hands-on stuff");
        course.addReviews(review);
        review.setCourse(course);
        em.persist(review);
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews){
        Course course = findById(courseId);
        for(Review review : reviews){
            course.addReviews(review);
            review.setCourse(course);
            em.persist(review);
        }

    }


}
