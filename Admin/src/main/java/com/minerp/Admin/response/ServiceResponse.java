package com.minerp.Admin.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceResponse<T> {

	private HttpStatus statusCode;
	private String statusDescription;
	private List<T> data;
	private Long count;
}
