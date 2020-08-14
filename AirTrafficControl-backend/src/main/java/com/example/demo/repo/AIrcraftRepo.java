package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Aircraft;

@Repository
public interface AIrcraftRepo extends CrudRepository<Aircraft, String>  {

}
