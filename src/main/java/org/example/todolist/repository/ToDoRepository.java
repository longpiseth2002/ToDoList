package org.example.todolist.repository;

import org.example.todolist.model.ToDo;

import java.util.List;
import java.util.Optional;


public interface ToDoRepository {

    public List<ToDo> getToDos();
    List<ToDo> view();
    ToDo create(ToDo todo);
    List<ToDo> delete(List<ToDo> todos, Integer id);
    ToDo update(List<ToDo> todoList , int id);
    List<ToDo> searchList(String task);
    Optional<ToDo> getTodoById (int id);

}
