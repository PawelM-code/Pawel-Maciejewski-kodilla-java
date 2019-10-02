package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {
    @Autowired
    @Qualifier("toDo")
    TaskList toDoList;

    @Autowired
    @Qualifier("progress")
    TaskList inProgressList;

    @Autowired
    @Qualifier("done")
    TaskList doneList;

    @Bean(name = "toDo")
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean(name = "progress")
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean(name = "done")
    public TaskList getDoneList() {
        return new TaskList();
    }

    @Bean
    public Board getBoard() {
        return new Board(toDoList, inProgressList, doneList);
    }
}
