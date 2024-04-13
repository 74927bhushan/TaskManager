package com.taskmanager.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.taskmanager.entities.Tasks;

@Service
public class TaskService {

	private ArrayList<Tasks> tasks = new ArrayList<>();
	private int taskid=1;
	
	public Tasks addTask(String title, String description,String deadline) {
		Tasks task = new Tasks();
		task.setId(taskid);
		task.setTitle(title);
		task.setDescription(description);
		task.setDeadline(deadline);
		task.setCompleted(false);
		tasks.add(task);
		taskid++;
		return task;
	}
	
	public ArrayList<Tasks> getTasks(){
		return tasks;
	}
	
	Tasks getTaskByid(int id) {
		for(Tasks t : tasks) {
			if(t.getId()==id) {
				return t;
			}
		}
		return null;
	}
	
}
