package com.example.rest.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/users")
public class RestBasicController {
	
	//①
	@GetMapping(params = "age")
	public ResponseEntity<Map<String, Object>>testParam(@RequestParam Integer age) {
		
		Map<String, Object> body = Map.of("receiveAge", age);
		
		return ResponseEntity.ok(body); //200OK
	}
	
	//②
	@GetMapping
	public ResponseEntity<List<Map<String, Object>>> getUserAll() {
		
		List<Map<String, Object>> list = List.of
				(Map.of("id", 1, "name", "山田"), Map.of("id", 2, "name", "鈴木")
						);
		
		return ResponseEntity.ok(list); // 200 ok
		
	}
	
	//③
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id) {
		
		if ((id == 1) || (id == 2)) {
			
			Map<String, Object> map = (id == 1) ? Map.of("id", 1, "name", "山田") :
				Map.of("id", 2, "name", "鈴木");
			
			return ResponseEntity.ok(map); // 200 ok
		}
		
		return ResponseEntity.notFound().build(); // 404 Not Foundを返す
	}
	
	//④
	@PostMapping
	public ResponseEntity<Map<String, Object>> postUser(@RequestBody Map<String, Object> req) {
		
		String name = (String) req.get("name"); // リクエストからnameを取り出してるだけ。
		
		//異常系のif分岐
		if(name == null) {
			return ResponseEntity.badRequest().body(Map.of("error", "nameは必須です。")); //404 Bad Request
		}
		
		int id = 3;  //固定でID = 3 に新規登録（post）処理した想定。
		
		// 正常系
		
		//レスポンスのヘッダー情報生成
		URI location = ServletUriComponentsBuilder  
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(id)
				.toUri();
		
		// レスポンスボディ
		Map<String, Object> body = Map.of("id", id, "name" , name);
		
		return ResponseEntity.created(location).body(body);
	}
}