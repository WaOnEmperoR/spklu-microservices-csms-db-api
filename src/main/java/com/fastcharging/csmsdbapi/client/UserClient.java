package com.fastcharging.csmsdbapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fastcharging.csmsdbapi.dto.UserRestConsumer;

@FeignClient(name = "user-service/api/action/user")
public interface UserClient {

    @GetMapping("/detail")
    public UserRestConsumer getUserDetail(@RequestHeader HttpHeaders headers);
}
