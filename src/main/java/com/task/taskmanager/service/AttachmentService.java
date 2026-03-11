package com.task.taskmanager.service;

import com.task.taskmanager.entity.Attachment;
import com.task.taskmanager.entity.Task;
import com.task.taskmanager.repository.AttachmentRepository;
import com.task.taskmanager.repository.TaskRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final TaskRepository taskRepository;

    public Attachment uploadAttachment(Long taskId, Attachment attachment) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        attachment.setTask(task);

        return attachmentRepository.save(attachment);
    }

    public List<Attachment> getAllAttachments() {
        return attachmentRepository.findAll();
    }

    public Attachment getAttachmentById(Long id) {
        return attachmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attachment not found"));
    }

    public void deleteAttachment(Long id) {
        attachmentRepository.deleteById(id);
    }
}
