package com.springbootproject.todowebapp.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    //hard coded list // need to initialized
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount =0;
    //create a static list hold todos
    static {
        todos.add(new Todo(++todosCount, "in28minutes","Get AWS Certified 1",
                LocalDate.now().plusYears(1), false ));
        todos.add(new Todo(++todosCount, "in28minutes","Learn DevOps 1",
                LocalDate.now().plusYears(2), false ));
        todos.add(new Todo(++todosCount, "in28minutes","Learn Full Stack Development 1",
                LocalDate.now().plusYears(3), false ));
    }
    //find user by his name
    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate =
                todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    //insert todos
    public void addTodo(String username,String desc,LocalDate tDate,boolean isDone){
        Todo todo = new Todo(++todosCount,username,desc,tDate,isDone);
        todos.add(todo);
    }
    //delete todos
    public void deleteById(int id){
        //create predicate which can validate or safe remove
        //todo.getId() == id
        //Lambda Expression
        //todo->todo.getid() ==id //lambda fun
        //every raw need check every given id is matched
        Predicate<?super Todo> predicate=todo ->todo.getId() ==id;
        //if matched the predicate then remove this object in that
        todos.removeIf(predicate);
    }

    public Todo findById(int id){
        Predicate<?super Todo> predicate=todo ->todo.getId() ==id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
    //update todos lists
    public void updateTodo(@Valid Todo todo){
        deleteById(todo.getId());
        todos.add(todo);
    }

}
