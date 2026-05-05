package com.example.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor	 //finalの「フィールド」を初期化するコンストラクタを自動生成
public class UserController {
	
	private final UserService userService; //サービス層のオブジェクトをDIする
	
	// /api/usersから一覧取得するメソッド getUserAll()
	public ResponseEntity<List<Map<String, Object>>> getUserAll() {
		List<Map<String, Object>> list = userService.findAll();
		
		return ResponseEntity.ok(list);
	}
	
}// 5/6
