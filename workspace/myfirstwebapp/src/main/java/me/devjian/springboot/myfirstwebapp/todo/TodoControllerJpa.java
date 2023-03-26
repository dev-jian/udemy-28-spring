package me.devjian.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class TodoControllerJpa {

	private final Logger log = LoggerFactory.getLogger(TodoController.class);
	
	private final TodoRepository todoRepository;
	
	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}
	
	@PostMapping("update-todo")
	public String showUpdateTodoPage(@Valid Todo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedInUsername();
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	@GetMapping("update-todo")
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo theTodo = todoRepository.findById(id).get();
		model.put("todo", theTodo);
		return "todo";
	}
	
	@GetMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@PostMapping("add-todo")
	public String addNewTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedInUsername();
		todo.setUsername(username);
		Todo savedTodo = todoRepository.save(todo);
		log.debug("저장된 Todo: {}", savedTodo);
		return "redirect:list-todos";
	}
	
	@GetMapping("add-todo")
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername();
		Todo todo = new Todo(0, username, "Default Value", LocalDate.now(), false);
		model.put("todo", todo);
		return "todo";
	}
	
	@GetMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername();
		model.put("todoList", todoRepository.findByUsername(username));
		return "listTodos";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
