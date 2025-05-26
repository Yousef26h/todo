package com.example.task_service.entity;

import com.example.task_service.data.STATUS;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private STATUS status;
    private LocalDateTime dueDate;
    private LocalDateTime createdTs;
    private LocalDateTime updatedTs;
}
