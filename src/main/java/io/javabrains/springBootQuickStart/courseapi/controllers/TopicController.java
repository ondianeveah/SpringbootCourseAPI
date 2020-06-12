package io.javabrains.springBootQuickStart.courseapi.controllers;

import io.javabrains.springBootQuickStart.courseapi.JavaBrainsCourseApiApplication;
import io.javabrains.springBootQuickStart.courseapi.domains.Topic;
import io.javabrains.springBootQuickStart.courseapi.services.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    private static final Logger log = LoggerFactory.getLogger(JavaBrainsCourseApiApplication.class);

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public List<Topic> getAllTopics(){
        log.info("Got All Topics");
        return topicService.getAllTopics();
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.GET)
    public Optional<Topic> getTopicById(@PathVariable String id){
        log.info("Got one Topic by Id");
        return topicService.getTopicById(id);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public void createTopic(@RequestBody Topic topic){
        log.info("Created Topic By Id");
         topicService.createTopic(topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    public void updateTopicById(@RequestBody Topic topic, @PathVariable String id){
        log.info("Updated Topic By Id");
        topicService.updateTopicById(id, topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public void deleteTopicById(@PathVariable String id){
        log.info("Deleted Topic By Id");
        topicService.deleteTopicById(id);
    }
}
