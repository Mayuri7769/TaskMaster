package com.task.taskmanager.controller;

import com.task.taskmanager.entity.Comment;
import com.task.taskmanager.service.CommentService;
import com.task.taskmanager.entity.Task;
import com.task.taskmanager.repository.CommentRepository;
import com.task.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/tasks/{taskId}/comments")
    public Comment addComment(@PathVariable Long taskId,
                              @RequestBody Comment comment) {
        return commentService.addComment(taskId, comment);
    }

    @GetMapping("/tasks/{taskId}/comments")
    public List<Comment> getComments(@PathVariable Long taskId) {
        return commentService.getComments(taskId);
    }

    @DeleteMapping("/comments/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return "Comment deleted successfully";
    }
}