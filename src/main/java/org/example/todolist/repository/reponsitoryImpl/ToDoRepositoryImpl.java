package org.example.todolist.repository.reponsitoryImpl;

import lombok.Getter;
import org.example.todolist.model.ToDo;
import org.example.todolist.repository.ToDoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Getter
@Repository
public class ToDoRepositoryImpl implements ToDoRepository {
    private final List<ToDo> toDos = new ArrayList<>() {{
        add(new ToDo(1, "Writing", "opo", true, LocalDate.now()));
        add(new ToDo(2, "Writing", "opo", true, LocalDate.now()));
        add(new ToDo(3, "Writing", "opo", true, LocalDate.now()));
        add(new ToDo(4, "Writing", "opo", true, LocalDate.now()));
        add(new ToDo(5, "Writing", "opo", true, LocalDate.now()));
        add(new ToDo(6, "Writing", "opo", true, LocalDate.now()));
    }};


    @Override
    public List<ToDo> view() {
        return null;
    }

    @Override
    public ToDo create( ToDo toDo) {
        toDos.add(toDo);
        return toDo;
    }

    @Override
    public List<ToDo> delete(List<ToDo> todos, Integer id) {
        for(ToDo todo : todos){
            if(todo.getId() == id){
                todos.remove(todo);
            }
        }
        return todos;
    }

    @Override
    public ToDo update(List<ToDo> todoList, int id) {
        Optional<ToDo> toDo = todoList.stream().filter(todo -> todo.getId() == id).findFirst();
        if(toDo.isPresent())
        {
            return toDo.get();
        }
        return null;
    }

    @Override
    public List<ToDo> searchList(String task) {
        List<ToDo> searchResult = toDos.stream()
                .filter(todo -> todo.getTask().equalsIgnoreCase(task))
                .collect(Collectors.toList());
        return searchResult;
    }
    public Optional<ToDo> getTodoById(int id){
       return toDos.stream().filter(toDo -> toDo.getId() == id).findFirst();
    }
}
