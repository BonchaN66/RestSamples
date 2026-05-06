package com.example.rest.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryinMemory implements UserRepository {

	@Override
	public List<Map<String, Object>> selectAll() {
		
		// 練習のため固定でMapオブジェクトを二校用意
		List<Map<String, Object>> list 
		= List.of(Map.of("id", 1, "name", "山田"), Map.of("id", 2, "name", "鈴木"));
		
		return list;
	}

}
