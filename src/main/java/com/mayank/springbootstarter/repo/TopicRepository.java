package com.mayank.springbootstarter.repo;

import org.springframework.data.repository.CrudRepository;

import com.mayank.springbootstarter.models.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
