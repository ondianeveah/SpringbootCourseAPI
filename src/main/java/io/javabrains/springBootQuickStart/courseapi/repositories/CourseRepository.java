package io.javabrains.springBootQuickStart.courseapi.repositories;

import io.javabrains.springBootQuickStart.courseapi.domains.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//video 31, VERY HELPFUL
import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {
    List<Course> findByTopicId(String topicId);
  //  List<Course> findByDescription(String description);
}
