package com.example.backend6.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.backend6.Models.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

}