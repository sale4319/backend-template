package com.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class TemplateModel {
    @Id
    private String id;
    private String username;
    private String name;
    private String email;

}