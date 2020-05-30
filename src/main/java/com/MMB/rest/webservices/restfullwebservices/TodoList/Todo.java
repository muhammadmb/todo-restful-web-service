package com.MMB.rest.webservices.restfullwebservices.TodoList;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;

@Entity

public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String description;
    private boolean done;
    private Date targetDate;

    public Todo() {
    }

    public Todo(Long id, String userName, String description, boolean done, Date targetDate) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.done = done;
        this.targetDate = targetDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }
}