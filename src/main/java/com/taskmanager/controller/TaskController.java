package com.taskmanager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.DTO.CreateTaskDTO;
import com.taskmanager.entities.Tasks;
import com.taskmanager.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	private final TaskService taskservice;
	
	public TaskController(TaskService taskservice) {
		this.taskservice=taskservice;
	}

	@GetMapping("")
	public ResponseEntity<List<Tasks>> getTasks(){
		var tasks = taskservice.getTasks();
		
		return ResponseEntity.ok(tasks);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Tasks>> getTaskById(int id){
		var tasks = taskservice.getTasks();
		if(tasks==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(tasks);
	}
	
	@PostMapping("")
	public ResponseEntity<Tasks> addTask(@RequestBody CreateTaskDTO taskdto){
		var task =taskservice.addTask(taskdto.getTitle(),taskdto.getDescription(),taskdto.getDeadline());
		return ResponseEntity.ok(task);
	}
	
	
}
