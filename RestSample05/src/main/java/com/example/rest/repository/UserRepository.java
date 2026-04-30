package com.example.rest.repository;

import java.util.List;
import java.util.Map;

public interface UserRepository {
	
	List<Map<String,Object>> selectAll();
	
}
