package com.fastcharging.csmsdbapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRestConsumer {

	private UserDto data;
	private String message;
	private String status;
}
