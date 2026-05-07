package com.example.rest.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// DTO (データ受渡用クラス)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {
	
	private Long id;
	private String title;
	private String description;
	private LocalDate dueDate;
	private Boolean done;
	private String city;
	
}
