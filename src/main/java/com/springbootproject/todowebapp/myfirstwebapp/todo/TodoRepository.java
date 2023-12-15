package com.springbootproject.todowebapp.myfirstwebapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
    public List<Todo> findByUsername(String username);
}
