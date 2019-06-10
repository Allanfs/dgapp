package com.github.allanfs.dgapp.dgapp.pizza.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

public class ApiErrorData {
	
	@Setter
	@Getter
	private HttpStatus status;
	@Setter
	@Getter
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	@Setter
	@Getter
	private String message;
	@Setter
	@Getter
	private String debugMessage;

	public ApiErrorData() {
	}
	
	public ApiErrorData(HttpStatus status) {
		this.status = status;
	}
}