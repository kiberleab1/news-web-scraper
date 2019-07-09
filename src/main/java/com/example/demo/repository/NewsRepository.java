package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.*;

public interface NewsRepository extends CrudRepository<News,Long> {

}
