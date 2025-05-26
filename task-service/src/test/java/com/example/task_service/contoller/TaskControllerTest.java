package com.example.task_service.contoller;

import com.example.task_service.controller.TaskController;
import com.example.task_service.entity.Task;
import com.example.task_service.repo.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskController subject;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllTasksEndpoint() throws Exception {
        List<Task> tasks = new ArrayList<>();
        tasks.add(Task.builder().id(1L).build());
        when(taskRepository.findAll()).thenReturn(tasks);

        mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
                .andExpect(status().isOk());
//                .andExpect(
//                        content().json(
//                                objectMapper.writeValueAsString(
//                                        Task.builder().id(1L).build())));

    }
}
