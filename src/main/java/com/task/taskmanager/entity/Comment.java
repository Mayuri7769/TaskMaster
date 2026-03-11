package com.task.taskmanager.entity;

import jakarta.persistence.*;

import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    private User user;

    // don't need to set createdAt manually in service
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

}
