package com.task.taskmanager.entity;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String fileUrl;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
