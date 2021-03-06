package com.curso.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StandardError implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timeStamp;
	private Integer status;
	private String message;
	private String error;
	private String path;

	public StandardError(Instant timeStamp, Integer status, String message, String error, String path) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.message = message;
		this.error = error;
		this.path = path;
	}

}
