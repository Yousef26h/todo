package com.example.task_service.controller;

import com.example.task_service.entity.Task;
import com.example.task_service.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;
//
//    public TaskController(TaskRepository taskRepository) {
//        this.taskRepository = taskRepository;
//    }

    @GetMapping(value = {"","/"})
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
