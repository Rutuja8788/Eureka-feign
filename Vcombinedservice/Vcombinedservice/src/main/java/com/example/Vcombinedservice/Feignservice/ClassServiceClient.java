package com.example.Vcombinedservice.Feignservice;


import com.example.Vcombinedservice.Dto.ClassDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "class-service")
public interface ClassServiceClient
{

    @PostMapping("/classes/create")
    String createClass(@RequestBody ClassDto classEntity);
}

