package org.example.todolist.repository;

import org.example.todolist.model.ToDo;

import java.util.List;
import java.util.Optional;


public interface ToDoRepository {

    public List<ToDo> getToDos();
    ToDo create(ToDo todo);
    List<ToDo> delete(int id);
    List<ToDo> searchList(String task , boolean isDone);
    public ToDo updateToDo(int id, ToDo personDetails);

}
