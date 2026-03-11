package com.task.taskmanager.controller;

import com.task.taskmanager.entity.Attachment;
import com.task.taskmanager.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attachments")
@RequiredArgsConstructor
public class AttachmentController {

    private final AttachmentService attachmentService;

    // Upload attachment for task
    @PostMapping("/task/{taskId}")
    public Attachment uploadAttachment(@PathVariable Long taskId,
                                       @RequestBody Attachment attachment) {

        return attachmentService.uploadAttachment(taskId, attachment);
    }

    // Get all attachments
    @GetMapping
    public List<Attachment> getAllAttachments() {
        return attachmentService.getAllAttachments();
    }

    // Get attachment by ID
    @GetMapping("/{id}")
    public Attachment getAttachmentById(@PathVariable Long id) {
        return attachmentService.getAttachmentById(id);
    }

    // Delete attachment
    @DeleteMapping("/{id}")
    public String deleteAttachment(@PathVariable Long id) {

        attachmentService.deleteAttachment(id);

        return "Attachment deleted successfully";
    }

}
