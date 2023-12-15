package com.springbootproject.todowebapp.myfirstwebapp.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
//DataBase (MySQL)
//Static List of todos = = = > H2,mysql

//jpa allows to map bean to the database
//so then move

@Entity
public class Todo {

    @Id
    private int id;
    private String username;
    //validate in minimimun length
    @Size(min=10,message = "Enter atleast 10 character here")
    private String desc;
    private LocalDate targetDate;
    private boolean done;

    public Todo(int id, String username, String desc, LocalDate targetDate, boolean done) {
        this.id = id;
        this.username = username;
        this.desc = desc;
        this.targetDate = targetDate;
        this.done = done;
    }

    public Todo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", desc='" + desc + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}
