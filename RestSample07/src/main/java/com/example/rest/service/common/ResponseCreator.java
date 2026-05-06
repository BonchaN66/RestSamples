package com.example.rest.service.common;

import java.util.List;

import com.example.rest.domain.entity.Task;
import com.example.rest.dto.response.TaskResponse;

public interface ResponseCreator {
	
	TaskResponse createTaskResponse(Task e); //Entity(Task)からDTO(TaskResponse)を返却するメソッド
	
	List<TaskResponse> createTaskResponseList(List<Task> l);
}
