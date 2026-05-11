package com.example.rest.service.biz;

import java.util.List;

import com.example.rest.dto.response.TaskResponse;

public interface TaskService {
	
	List<TaskResponse> findAll();
	TaskResponse findById(Long id);
	
}
