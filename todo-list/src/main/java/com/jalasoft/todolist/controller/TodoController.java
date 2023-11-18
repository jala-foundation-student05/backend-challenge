package com.jalasoft.todolist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalasoft.todolist.domain.Todo;
import com.jalasoft.todolist.dto.TodoDTO;
import com.jalasoft.todolist.service.TodoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody TodoDTO todo) {
        Todo newTodo = todoService.createTodo(todo);
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        List<Todo> todos = todoService.findAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@RequestBody TodoDTO data, @PathVariable Long id) throws Exception {
        Todo todo = new Todo(data);
        todo.setId(id);
        Todo updatedTodo = todoService.updateTodo(todo);
        return ResponseEntity.ok().body(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws Exception{
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
