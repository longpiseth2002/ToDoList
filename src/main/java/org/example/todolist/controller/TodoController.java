package org.example.todolist.controller;

import org.example.todolist.model.ToDo;
import org.example.todolist.service.serviceImpl.ToDoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/todo")
public class TodoController {
    private final ToDoServiceImpl toDoServiceImpl;
    TodoController(  ToDoServiceImpl toDoServiceImpl){
        this.toDoServiceImpl = toDoServiceImpl;
    }

    @GetMapping("/list")
    public String getAll(Model model){
        model.addAttribute("toDosList" , toDoServiceImpl.getAll());
        return "index";
    }

    @GetMapping("/new")
    public String add(){
        return "add-todo";
    }


    @PostMapping("/new")
    public String addProduct(@ModelAttribute ToDo toDo) {
        toDoServiceImpl.create(toDo);
        return "redirect:/todo/list";
    }
@GetMapping("/edit/{id}")
    public String getViewEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("todo", toDoServiceImpl.getTodoById(id));
        return "edit-todo";
    }
    @PostMapping("/update/{id}")
    public String updateTodo(){
        return"redirect:/todo/list";
    }


}
