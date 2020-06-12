package io.javabrains.springBootQuickStart.courseapi.controllers;

import io.javabrains.springBootQuickStart.courseapi.JavaBrainsCourseApiApplication;
import io.javabrains.springBootQuickStart.courseapi.domains.Course;
import io.javabrains.springBootQuickStart.courseapi.domains.Topic;
import io.javabrains.springBootQuickStart.courseapi.services.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    private static final Logger log = LoggerFactory.getLogger(JavaBrainsCourseApiApplication.class);

    @RequestMapping(value = "topics/{id}/courses", method = RequestMethod.GET)
    public List<Course> getAllCourses(@PathVariable String id){
        log.info("Got All Courses");
        return courseService.getAllCourses(id);
    }

    @RequestMapping(value = "topics/{topicId}/courses/{id}", method = RequestMethod.GET)
    public Optional<Course> getCourseById(@PathVariable String id){
        log.info("Got one Course by Id");
        return courseService.getCourseById(id);
    }

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
    public void createCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        log.info("Created Course By Id");
        courseService.createCourse(course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.PUT)
    public void updateCourseById(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){
        course.setTopic(new Topic(topicId, "", ""));
        log.info("Updated Course By Id");
        courseService.updateCourseById(course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.DELETE)
    public void deleteCourseById(@PathVariable String id){
        log.info("Deleted Course By Id");
        courseService.deleteCourseById(id);
    }
}
