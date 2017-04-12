package com.mayank.springbootstarter.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mayank.springbootstarter.models.Course;

public interface CourseRepository extends CrudRepository<Course, String> {
	public List<Course> findByTopicId(String topicId);
}
