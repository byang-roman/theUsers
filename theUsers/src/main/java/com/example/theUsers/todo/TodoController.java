package com.example.theUsers.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/todo")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping
    public List<Todo> getUsers (){
        return todoService.getUsers();
    }

    @GetMapping("{id}")
    public Todo getUserById(@PathVariable("id") Integer id){
        return todoService.getUserById(id);
    }

    @PostMapping
    public void registerNewUser(@RequestBody Todo todo){
        todoService.addUsers(todo);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        todoService.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) LocalDate targetDate

    ){
        todoService.updateUser(id, username, description, targetDate);
    }
}
