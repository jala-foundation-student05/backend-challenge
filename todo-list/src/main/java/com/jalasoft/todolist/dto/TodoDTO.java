package com.jalasoft.todolist.dto;

import java.time.LocalDateTime;
import java.util.Date;

public record TodoDTO(String title, String description, String category, Date dueDate, String status, boolean isActive, LocalDateTime lastUpdate) {
    
}
