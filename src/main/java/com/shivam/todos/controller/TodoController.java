package com.shivam.todos.controller;

import com.shivam.todos.model.Todo;
import com.shivam.todos.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {


    public TodoController(TodoRepository repository)
    {
        this.repository = repository;
    }
    TodoRepository repository;

    @RequestMapping(value = "/v1/todos", method =  RequestMethod.GET)
    public String list(Model model)
    {

        model.addAttribute("todo",new Todo());
        model.addAttribute("todos", repository.findAll());
        return "todolist";
    }

    @RequestMapping(value = "/v1/addTodo" , method = RequestMethod.POST)
    public String addTodo(@ModelAttribute("todo") Todo todo)
    {
        System.out.println(todo.getDescription());

        repository.save(todo);
        return "redirect:/v1/todos";
    }

    @RequestMapping(value = "/delete-todo" , method = RequestMethod.GET)
    public String deleteTodo(@RequestParam("id") long id)
    {
        repository.deleteById(id);
        return "redirect:/v1/todos";
    }
}
