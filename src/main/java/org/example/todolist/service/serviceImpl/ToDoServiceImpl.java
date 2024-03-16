package org.example.todolist.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.todolist.model.ToDo;
import org.example.todolist.repository.reponsitoryImpl.ToDoRepositoryImpl;
import org.example.todolist.service.ToDoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepositoryImpl toDoRepositoryImpl;
    public List<ToDo> getAll(){
        return toDoRepositoryImpl.getToDos();
    }


    @Override
    public ToDo create( ToDo toDo) {
        return toDoRepositoryImpl.create( toDo);
    }

    @Override
    public List<ToDo> delete( int id) {
        return toDoRepositoryImpl.delete(id);
    }


    @Override
    public List<ToDo> searchList(String task , boolean isDone) {
        return toDoRepositoryImpl.searchList(task,isDone);
    }

    @Override
    public ToDo getToDoById(int id) {
        return toDoRepositoryImpl.getToDoById(id);
    }


    @Override
    public ToDo updateToDo(int id, ToDo personDetails) {
        return toDoRepositoryImpl.updateToDo(id,personDetails);
    }


}
