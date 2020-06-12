package io.javabrains.springBootQuickStart.courseapi.services;

import io.javabrains.springBootQuickStart.courseapi.domains.Topic;
import io.javabrains.springBootQuickStart.courseapi.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;


    public List<Topic> getAllTopics(){
        List<Topic> listOfTopics = new ArrayList<>();
        topicRepository.findAll().forEach(listOfTopics::add);
        return listOfTopics;
    }

    public void createTopic(Topic topic){
        topicRepository.save(topic);
    }


    public Optional<Topic> getTopicById(String id){
         return topicRepository.findById(id);
    }

    public void updateTopicById(String id, Topic topic){
       topicRepository.save(topic);
    }

    public void deleteTopicById(String id){
        topicRepository.deleteById(id);
    }
}
