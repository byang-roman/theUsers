package com.example.theUsers.todo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TodoDTO {
    private Integer id;
    private String username;
    private String description;
    private LocalDate targetDate;
}
