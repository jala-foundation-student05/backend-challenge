package com.jalasoft.todolist.domain;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jalasoft.todolist.dto.TodoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;

    private String description;

    private String category;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    private String status;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private LocalDateTime lastUpdate;

    public Todo(TodoDTO data) {
        this.title = data.title();
        this.description = data.description();
        this.category = data.category();
        this.dueDate = data.dueDate();
        this.status = data.status();
        this.isActive = data.isActive();
        this.lastUpdate = data.lastUpdate();
    }

}
