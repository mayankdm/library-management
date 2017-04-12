package com.mayank.springbootstarter.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayank.springbootstarter.models.Course;
import com.mayank.springbootstarter.models.Topic;
import com.mayank.springbootstarter.repo.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repo;
	
	public List<Course> getAllCourses(String topicId){
		List list = new ArrayList<>();
		repo.findByTopicId(topicId)
		.forEach(list::add);
		return list;
	}
	
	public Course getCourse(String id){
		return repo.findOne(id);
	}
	
	public void addCourse(Course course) {
		//topics.add(topic);
		repo.save(course);
	}
	
	public void updateCourse(Course course) {
		repo.save(course);
	}

	public void deleteCourse(String id) {
		repo.delete(id);
	}
}
