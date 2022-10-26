package com.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.TemplateModel;

@Repository
public interface TemplateRepository extends MongoRepository<TemplateModel, String> {

}
