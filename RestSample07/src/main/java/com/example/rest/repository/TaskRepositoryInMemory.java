package com.example.rest.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.rest.domain.entity.Task;

@Repository
public class TaskRepositoryInMemory implements TaskRepository {
	
	private List<Task> store; //タスクリスト
	private long nextId; // ID採番用
	
	// まずはコンストラクタ生成↓
	public TaskRepositoryInMemory() {
		
		//フィールド初期化
		store = new ArrayList<>();
		nextId = 1;
		
		//初期データ生成
		store.add(new Task( //Taskクラスのインスタンスを生成して初期値を設定store(Listクラス)に代入
				nextId++, "最初のタスク", "年度計画です", LocalDate.parse("2026-04-01"), false, "Tokyo"));
		
		store.add(new Task(
				nextId++, "Rest API Fes.", "大阪イベント準備", LocalDate.parse("2026-04-03"), false, "Osaka"));
		
	}
	//↑コンストラクタここまで。
	
	@Override
	public List<Task> selectAll() { //一覧取得メソッド
		return store;
	}

	@Override
	public Task selectById(Long id) { //一件取得するメソッド
		
		Task result = null; //初期化でnull設定しておく
		
		for(Task task : store) {
			if(task.getId().equals(id)) {
				result = task;
				break;
			}
		}
		return result;
	}

}
