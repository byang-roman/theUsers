package com.example.theUsers.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TodoConfig {
    @Bean
    CommandLineRunner commandLineRunner(TodoRepository repository){
        return args -> {
            Todo vhi = new Todo("Vhianne","SE Intern",
                    LocalDate.of(2022,Month.APRIL,8)
            );
            repository.saveAll(
                    List.of(vhi)
            );
        };
    }
}
