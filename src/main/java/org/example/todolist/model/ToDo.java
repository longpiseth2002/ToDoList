package org.example.todolist.model;

import lombok.*;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@Getter
@Setter
public class ToDo {
    private int id;
    private String task ;
    private String description;
    private boolean isDone;
    private LocalDate createdAt;
    public ToDo(){
        this.createdAt = LocalDate.now();
    }

}
