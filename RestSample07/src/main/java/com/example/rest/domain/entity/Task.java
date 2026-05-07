package com.example.rest.domain.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity：業務データ本体
@Data // getter / setter 自動生成
@NoArgsConstructor //引数なしコンストラクタを自動生成
@AllArgsConstructor //全フィールド初期化コンストラクタを自動生成
public class Task {
	
	// フィールド（カラム メンバ変数）
	private Long id;
	private String title;
	private String description;
	private LocalDate dueDate;
	private Boolean done;
	private String city;
	
}
