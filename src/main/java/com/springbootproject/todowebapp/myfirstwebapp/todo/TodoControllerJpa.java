package com.springbootproject.todowebapp.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;


@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

    private TodoRepository todoRepository;

    public TodoControllerJpa(TodoRepository todoRepository) {
        super();
        this.todoRepository = todoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        String username = getLoggedInUsername(model);

        List<Todo> todos = todoRepository.findByUsername(username);
        model.addAttribute("todos", todos);

        return "listTodos";
    }


    //todo object ekata bind krala thyenne 2 way bind - post and get kraddith
    //get ekedi kranne

    @RequestMapping(value = "add-todos",method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String username = getLoggedInUsername(model);
        Todo todo = new Todo(0,username,"Type Here",
                LocalDate.now().plusYears(1),
                false);
        //used to add an attribute to the model.
        model.put("todo",todo);
        return "todo";
    }
    //valid  - used for karana validation todo1' ge field wala thyena
    //BindingResult used for check and valid

    @RequestMapping(value = "add-todos",method = RequestMethod.POST)
    public String addNewTodo(ModelMap model,@Valid Todo todo,BindingResult re){

        //if has a error(at least 10 character) this will return todo1 page
        if(re.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
//        todoService.addTodo(username,todo.getDesc(),
//                todo.getTargetDate() ,
//                false);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam int id){
        //delete to with specific id
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo",method =RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id,ModelMap model){
        //find todo and create todo and it pass to the todo page
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo",method = RequestMethod.POST)
    public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult re){

        //if has a error(at least 10 character) this will return todo1 page
        if(re.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    private static String getLoggedInUsername(ModelMap model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}


