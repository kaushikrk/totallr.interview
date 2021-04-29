package com.interview.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.dao.TaskRepo;
import com.interview.model.Task;

@RestController
public class TaskController {
	
	@Autowired
	TaskRepo repo;
	
	@CrossOrigin
	@GetMapping("/tasks")
	public List<Task> getTasks(){
		return repo.findAll();
	}
	
	@CrossOrigin
	@RequestMapping("/tasks/{id}")
	public Optional<Task> getTask(@PathVariable("id") int id){
		return repo.findById(id);
	}

	@CrossOrigin
	@PostMapping("/tasks")
	public Task createTask(@RequestBody Task task){
		return repo.save(task);
	}
	
	@CrossOrigin
	@PutMapping("/tasks/{id}")
	public Task updateTask(@RequestBody Task task,@PathVariable("id") int id) {
//		Task temp = repo.getOne(id);
//		return repo.save(temp);
		task.setId(id);
		repo.setCustomerName(id, task.getName());
		return task;
	}
	
	@CrossOrigin
	@DeleteMapping("/tasks/{id}")
	public Optional<Task> deleteTask(@PathVariable("id") int id) {
		Optional<Task> task = repo.findById(id);
		repo.deleteById(id);
		return task;
	}
}
