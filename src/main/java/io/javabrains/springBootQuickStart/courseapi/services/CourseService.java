package io.javabrains.springBootQuickStart.courseapi.services;

import io.javabrains.springBootQuickStart.courseapi.domains.Course;
import io.javabrains.springBootQuickStart.courseapi.domains.Topic;
import io.javabrains.springBootQuickStart.courseapi.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){
        List<Course> listOfCourses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(listOfCourses::add);
        return listOfCourses;
    }

    public void createCourse(Course course){
        courseRepository.save(course);
    }


    public Optional<Course> getCourseById(String id){
        return courseRepository.findById(id);
    }

    public void updateCourseById(Course course){
        courseRepository.save(course);
    }

    public void deleteCourseById(String id){
        courseRepository.deleteById(id);
    }
}
