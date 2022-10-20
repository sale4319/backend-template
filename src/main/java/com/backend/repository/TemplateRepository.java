package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.model.TemplateModel;

public interface TemplateRepository extends JpaRepository<TemplateModel, Long> {

}
