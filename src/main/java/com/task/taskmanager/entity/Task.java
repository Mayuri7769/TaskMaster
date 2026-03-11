package com.task.taskmanager.entity;

import com.task.taskmanager.model.TaskStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private TaskStatus status; // TODO, IN_PROGRESS, DONE

    // Task assigned to a user
    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    // Task belongs to a team/project
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    // Comments on task
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Comment> comments;

    // Attachments on task
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Attachment> attachments;

}