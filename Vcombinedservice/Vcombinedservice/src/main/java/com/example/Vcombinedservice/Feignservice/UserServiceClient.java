package com.example.Vcombinedservice.Feignservice;


import com.example.Vcombinedservice.Dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service")
public interface UserServiceClient
{

    @PostMapping("/users/register")
    String registerUser(@RequestBody UserDto user);
}

