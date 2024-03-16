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
    public ToDo create( ToDo toDo) {
        toDos.add(toDo);
        return toDo;
    }

    @Override
    public List<ToDo> delete(int id) {
        toDos.removeIf(todo -> todo.getId() == id);
        return toDos;
    }


    @Override
    public List<ToDo> searchList(String task, boolean isDone) {
        List<ToDo> searchResult = toDos.stream()
                .filter(todo -> todo.getTask().equalsIgnoreCase(task))
                .filter(todo -> todo.isDone() == isDone)
                .collect(Collectors.toList());
        return searchResult;
    }



    public ToDo getToDoById(int id) {
        return toDos.stream()
                .filter(person -> person.getId()== (id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
    }


    @Override
    public ToDo updateToDo(int id, ToDo toDosDetails) {
        ToDo toDos = getToDoById(id);
        toDos.setTask(toDosDetails.getTask());
        toDos.setDescription(toDosDetails.getDescription());
        toDos.setDone(toDosDetails.isDone());
        return toDos;
    }
}
