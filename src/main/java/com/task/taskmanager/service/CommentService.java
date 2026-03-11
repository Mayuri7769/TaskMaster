package com.task.taskmanager.service;


import com.task.taskmanager.entity.Comment;
import com.task.taskmanager.entity.Task;
import com.task.taskmanager.repository.CommentRepository;
import com.task.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    public Comment addComment(Long taskId, Comment comment) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        comment.setTask(task);

        //comment.setCreatedAt(LocalDateTime.now());

        return commentRepository.save(comment);
    }

    public List<Comment> getComments(Long taskId) {
        return commentRepository.findByTaskId(taskId);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
