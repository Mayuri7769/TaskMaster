package com.task.taskmanager.controller;

import com.task.taskmanager.entity.Attachment;
import com.task.taskmanager.repository.AttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attachments")
@RequiredArgsConstructor
public class AttachmentController {

    private final AttachmentRepository attachmentRepository;

    // Upload/save attachment
    @PostMapping
    public Attachment uploadAttachment(@RequestBody Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    // Get all attachments
    @GetMapping
    public List<Attachment> getAllAttachments() {
        return attachmentRepository.findAll();
    }

    // Get attachment by ID
    @GetMapping("/{id}")
    public Attachment getAttachmentById(@PathVariable Long id) {
        return attachmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attachment not found with id " + id));
    }

    // Delete attachment by ID
    @DeleteMapping("/{id}")
    public String deleteAttachment(@PathVariable Long id) {
        attachmentRepository.deleteById(id);
        return "Attachment deleted with id: " + id;
    }

}
