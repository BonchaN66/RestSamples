package com.example.rest.service.common;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rest.domain.entity.Task;
import com.example.rest.dto.response.TaskResponse;

@Service //ServiceとしてBean化
public class ResponseCreatorImple implements ResponseCreator {

	@Override
	public TaskResponse createTaskResponse(Task e) {
		
		TaskResponse result = new TaskResponse(e.getId(), e.getTitle(), 
				e.getDescription(), e.getDueDate(), e.getDone(), e.getCity());
		
		return null;
	}

	@Override
	public List<TaskResponse> createTaskResponseList(List<Task> l) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
