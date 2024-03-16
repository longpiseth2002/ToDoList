package org.example.todolist.model;

import lombok.*;

import java.time.LocalDate;



@Getter
@Setter
@Data
@AllArgsConstructor
public class ToDo {
    private static int idCounter = 6;
    private int id;
    private String task;
    private String description;
    private boolean isDone;
    private LocalDate createdAt;

    public ToDo() {
        this.id = ++idCounter;
        this.createdAt = LocalDate.now();
    }
}
