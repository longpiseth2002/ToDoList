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

    TodoController(ToDoServiceImpl toDoServiceImpl) {
        this.toDoServiceImpl = toDoServiceImpl;
    }

    @GetMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("toDosList", toDoServiceImpl.getAll());
        return "index";
    }

    @GetMapping("/new")
    public String add() {
        return "add-todo";
    }


    @PostMapping("/new")
    public String addProduct(@ModelAttribute ToDo toDo, @RequestParam(value = "isDone", required = false) String isDoneValue) {
        boolean isDone = isDoneValue != null && isDoneValue.equals("true");
        toDo.setDone(isDone);
        toDoServiceImpl.create(toDo);
        return "redirect:/todo/list";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("todoEdit", toDoServiceImpl.getToDoById(id));
        return "edit-todo";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") int id, ToDo toDo) {
        toDoServiceImpl.updateToDo(id, toDo);
        return "redirect:/todo/list";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(@PathVariable("id") int id, Model model) {
        model.addAttribute("deleteToDo", toDoServiceImpl.getToDoById(id));
        return "delete-todo";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") int id) {
        toDoServiceImpl.delete(id);
        return "redirect:/todo/list";
    }


    @GetMapping("/search")
    public String search( Model model) {
        model.addAttribute("searchResult", toDoServiceImpl.getAll());
        return "search-todo";
    }






}
