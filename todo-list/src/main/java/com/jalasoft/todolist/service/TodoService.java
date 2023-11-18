package com.jalasoft.todolist.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jalasoft.todolist.domain.Todo;
import com.jalasoft.todolist.dto.TodoDTO;
import com.jalasoft.todolist.repository.TodoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoService {

    private TodoRepository repository;

    public List<Todo> findAllTodos() {
        return repository.findAll();
    }

    public Todo findById(Long id) throws Exception {
        Optional<Todo> todo = repository.findById(id);
        return todo.orElseThrow(() -> new Exception("Todo not found"));
    }

    public Todo createTodo(TodoDTO data) {
        Todo newTodo = new Todo(data);
        newTodo.setLastUpdate(LocalDateTime.now());
        newTodo.setActive(true);
        return repository.save(newTodo);
    }

    public Todo updateTodo(Todo data) throws Exception {
        Todo todoFound = findById(data.getId());
        todoFound.setTitle(data.getTitle());
        todoFound.setDescription(data.getDescription());
        todoFound.setCategory(data.getCategory());
        todoFound.setDueDate(data.getDueDate());
        todoFound.setStatus(data.getStatus());
        todoFound.setLastUpdate(LocalDateTime.now());
        return repository.save(todoFound);
    }

    public Todo deleteById(Long id) throws Exception {
        Todo todoFound = findById(id);
        todoFound.setActive(false);
        todoFound.setLastUpdate(LocalDateTime.now());
        return repository.save(todoFound);

    }
}
