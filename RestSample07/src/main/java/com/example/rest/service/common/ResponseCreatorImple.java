package com.example.rest.service.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rest.domain.entity.Task;
import com.example.rest.dto.response.TaskResponse;

@Service //ServiceとしてBean化
public class ResponseCreatorImple implements ResponseCreator {

	@Override
	public TaskResponse createTaskResponse(Task e) { 
		//Task(Entity)→TaskResponse（DTO）に変換。
		//今回はTaskの実データそのまま入れるだけ本来ならフィルターしたりする。
		
		TaskResponse result = new TaskResponse(e.getId(), e.getTitle(), 
				e.getDescription(), e.getDueDate(), e.getDone(), e.getCity());
		
		return result;
	}

	@Override
	public List<TaskResponse> createTaskResponseList(List<Task> l) { //仮引数
		
		List<TaskResponse> result = new ArrayList<>(); //空のリストを生成しDTOに入れる
		
		for (Task t : l) { // l ←　配列名（List名）。
			result.add(createTaskResponse(t)); 
			// 一件のタスクを作成するcreateTaskResonseメソッドを実行→
			//　→　それをresult(TaskResponse=DTOを入れる空リスト)につaddする。
			// それをリストlの要素数分実行。
		}
		
		return result;
	}

}
