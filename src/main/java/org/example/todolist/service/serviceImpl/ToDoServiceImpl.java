package org.example.todolist.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.todolist.model.ToDo;
import org.example.todolist.repository.reponsitoryImpl.ToDoRepositoryImpl;
import org.example.todolist.service.ToDoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepositoryImpl toDoRepositoryImpl;
    public List<ToDo> getAll(){
        return toDoRepositoryImpl.getToDos();
    }

    @Override
    public List<ToDo> view() {
        return toDoRepositoryImpl.view();
    }

    @Override
    public ToDo create( ToDo toDo) {
        return toDoRepositoryImpl.create( toDo);
    }

    @Override
    public List<ToDo> delete(List<ToDo> todos, Integer id) {
        return toDoRepositoryImpl.delete(todos,id);
    }

    @Override
    public ToDo update(List<ToDo> todoList, int id) {
        return toDoRepositoryImpl.update(todoList,id);
    }

    @Override
    public List<ToDo> searchList(String task) {
        return toDoRepositoryImpl.searchList(task);
    }

    @Override
    public Optional<ToDo> getTodoById(int id) {
        return Optional.empty();
    }
//    public void save(ToDo toDo) {
//        toDoRepository.save(toDo);
//    }

}
