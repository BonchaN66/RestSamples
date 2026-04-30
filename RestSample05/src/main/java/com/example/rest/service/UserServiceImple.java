package com.example.rest.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.rest.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor //　コンストラクタを自動生成するLombokのアノテーション
public class UserServiceImple implements UserService {

	// インフラ層(Repository)のオブジェクトをDIする
	private final UserRepository userRepository;
	
	// Service層（ビジネスロジック）
	@Override
	public List<Map<String, Object>> findAll() {
		
		//findAll()内で、インフラ層（repository）のselectAll()をDIして実行
		List<Map<String, Object>> list = userRepository.selectAll();
		
		return list; //ロジックいじらず単純返却
	}

}