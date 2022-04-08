package com.example.theUsers.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getUsers () {
        return todoRepository.findAll();
    }

    public void addUsers(Todo todo) {
        todoRepository.save(todo);
    }

    public void deleteUser(Integer id) {
        boolean exists = todoRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("user with id " + id + " does not exists");
        }
        todoRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(Integer id, String username, String description, LocalDate localDate) {
        Todo student = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "user with id " + id + " does not exists"
                ));
        if (username != null && username.length() > 0 &&
                !Objects.equals(student.getusername(), username)){
            student.setusername(username);
        }
        if (description != null && description.length() > 0 &&
                !Objects.equals(student.getDescription(), description)){
            student.setDescription(description);
        }


    }

    public Todo getUserById(Integer id) throws IllegalStateException {
        Optional<Todo> user = todoRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        } else{
            throw new IllegalStateException("User not found");
        }
    }
}
