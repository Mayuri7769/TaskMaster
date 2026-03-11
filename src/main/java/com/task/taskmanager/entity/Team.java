package com.task.taskmanager.entity;

import jakarta.persistence.*;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private User createdBy;

    @ManyToMany
    private List<User> members = new ArrayList<>();
}
