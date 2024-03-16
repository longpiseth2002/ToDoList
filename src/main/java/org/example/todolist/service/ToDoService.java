package org.example.todolist.service;

import org.example.todolist.model.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoService {
    public List<ToDo> getAll();
    ToDo create(ToDo toDo);
    List<ToDo> delete( int id);
    List<ToDo> searchList(String task , boolean isDone);

    public ToDo getToDoById(int id);
    public ToDo updateToDo(int id, ToDo personDetails);
}
