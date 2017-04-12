package com.mayank.springbootstarter.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayank.springbootstarter.models.Topic;
import com.mayank.springbootstarter.repo.TopicRepository;

@Service
public class TopicService {
	@Autowired
	private TopicRepository repo;
	
	/*private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring", "Spring Framework", "Spring Framework Description"),
			new Topic("Java", "Core Java", "Core Java Description"),
			new Topic("JavaScript", "JavaScript", "JavaScript Description")
	));*/
	
	public List<Topic> getAllTopics(){
		//return topics;
		List list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		return list;
	}
	
	public Topic getTopic(String id){
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return repo.findOne(id);
	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		repo.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		/*for(int i=0;i<topics.size();i++){
			if(topics.get(i).getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}*/
		
		repo.save(topic);
	}

	public void deleteTopic(Topic topic, String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		repo.delete(id);
	}
}
