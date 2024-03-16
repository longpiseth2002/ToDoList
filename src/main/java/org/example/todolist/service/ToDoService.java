package org.example.todolist.service;

import org.example.todolist.model.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoService {
    public List<ToDo> getAll();
    List<ToDo> view();
    ToDo create(ToDo toDo);
    List<ToDo> delete(List<ToDo> todos, Integer id);
    ToDo update(List<ToDo> todoList , int id);
    List<ToDo> searchList(String task);
    Optional<ToDo> getTodoById (int id);
}
