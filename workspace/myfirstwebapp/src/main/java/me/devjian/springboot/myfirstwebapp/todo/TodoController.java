package me.devjian.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@SessionAttributes("name")
//@Controller
public class TodoController {

	private final Logger logger = LoggerFactory.getLogger(TodoController.class);
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	@PostMapping("update-todo")
	public String showUpdateTodoPage(@Valid Todo todo, BindingResult result, ModelMap model) {
		
		logger.info("TODO 수정 요청...");
		
		if (result.hasErrors()) {
			return "todo";
		}
		
		logger.info("TODO 수정 요청 아이디: {}", todo.getId());
	
		String username = getLoggedInUsername();
		todo.setUsername(username);
		
		todoService.updateTodo(todo);
		
		return "redirect:list-todos";
	}
	
	@GetMapping("update-todo")
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		
		logger.info("TODO 수정 페이지 요청...");
		logger.info("TODO 수정 요청 아이디: {}", id);
		
		Todo theTodo = todoService.findById(id);
		
		model.put("todo", theTodo);
		
		return "todo";
	}
	
	@GetMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		logger.info("TODO 삭제 요청...");
		logger.info("TODO 삭제 요청 아이디: {}", id);
		
		todoService.deleteById(id);
		
		return "redirect:list-todos";
	}
	
	@PostMapping("add-todo")
	public String addNewTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedInUsername();
		
		todoService.addNewTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		
		return "redirect:list-todos";
	}
	
	@GetMapping("add-todo")
	public String showNewTodoPage(ModelMap model) {
		
		String username = getLoggedInUsername();
		Todo todo = new Todo(0, username, "Default Value", LocalDate.now().plusYears(1), false);
		
		model.put("todo", todo);
		
		return "todo";
	}
	
	@GetMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername();
		model.put("todoList", todoService.findByUsername(username));
		return "listTodos";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
