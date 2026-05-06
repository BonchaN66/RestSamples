package com.example.rest.repository;

import java.util.List;

import com.example.rest.domain.entity.Task;

public interface TaskRepository {

	//抽象メソッド
	List<Task> selectAll(); // Entitクラス（のフィールドのタスク達） をインポート。戻り値はTask型のリスト
	
	Task selectById(Long id);
	
}
