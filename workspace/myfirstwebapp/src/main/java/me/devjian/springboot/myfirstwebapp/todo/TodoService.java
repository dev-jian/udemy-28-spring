package me.devjian.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todoList = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todoList.add(new Todo(++todosCount, "devjian", "Learn Spring Basic", LocalDate.now().plusYears(1), false));
		todoList.add(new Todo(++todosCount, "jwkim", "Learn Spring Advanced", LocalDate.now().plusYears(2), false));
		todoList.add(new Todo(++todosCount, "jskim", "Learn Spring Basic", LocalDate.now().plusYears(3), false));
	}
	
	public void updateTodo(Todo todo) {
		deleteById(todo.getId());
		todoList.add(todo);
	}
	
	public Todo findById(int id) {
		
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		
		return todoList.stream().filter(predicate).findFirst().get();
	}
	
	public void deleteById(int id) {
		
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todoList.removeIf(predicate);
	}
	
	public void addNewTodo(String username, String description, LocalDate targetDate, boolean done) {
		
		Todo newTodo = new Todo(++todosCount, username, description, targetDate, done);
		todoList.add(newTodo);
	}
	
	public List<Todo> findAll() {
		
		return todoList;
	}
	
	public List<Todo> findByUsername(String username) {
		
		return todoList.stream().filter(todo -> todo.getUsername().equals(username)).toList();
	}
}
