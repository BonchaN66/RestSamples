package com.example.rest.service.biz;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rest.domain.entity.Task;
import com.example.rest.dto.response.TaskResponse;
import com.example.rest.repository.TaskRepository;
import com.example.rest.service.common.ResponseCreator;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TaskServiceImple implements TaskService {
	
	private final TaskRepository taskRepository;
	private final ResponseCreator responseCreator; 
	
	@Override
	public List<TaskResponse> findAll() {
		
		List<Task> tasks = taskRepository.selectAll();
		
		List<TaskResponse> result = responseCreator.createTaskResponseList(tasks);
		
		return result;
	}

	@Override
	public TaskResponse findById(Long id) {
		
		Task task = taskRepository.selectById(id);
		
		if (task == null) {
			throw new ResponseStatusException
			(HttpStatus.NOT_FOUND, "Task not found " + id);
		}
		
		TaskResponse result = responseCreator.createTaskResponse(task);
		
		return result;
	}

}
