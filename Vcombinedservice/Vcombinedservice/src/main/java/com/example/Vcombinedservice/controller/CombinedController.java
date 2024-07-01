package com.example.Vcombinedservice.controller;

import com.example.Vcombinedservice.Dto.ClassDto;
import com.example.Vcombinedservice.Dto.UserDto;
import com.example.Vcombinedservice.Feignservice.ClassServiceClient;
import com.example.Vcombinedservice.Feignservice.UserServiceClient;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/combined")
public class CombinedController
{

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private ClassServiceClient classServiceClient;

    @PostMapping("/feign/register")
    public String registerUser(@RequestBody UserDto user)
    {
        return userServiceClient.registerUser(user);
    }

    @PostMapping("/feign/createClass")
    public String createClass(@RequestBody ClassDto classEntity, @RequestParam String role) {
        if (!"instructor".equals(role))
        {
            return "Only instructors can create classes.";
        }

        return classServiceClient.createClass(classEntity);
    }

    // Method to register a new user
    @PostMapping("/register")
    public String registerUser(@RequestBody String user)
    {
        String userServiceUrl = getServiceUrl("user-service");

        HttpResponse<String> response = Unirest.post(userServiceUrl + "/users/register")
                .header("Content-Type", "application/json")
                .body(user)
                .asString();

        if (response.getStatus() == 200)
        {
            return "User registered successfully: " + response.getBody();
        } else
        {
            return "Failed to register user: " + response.getBody();
        }
    }

    // Method to create a new class
    @PostMapping("/createClass")
    public String createClass(@RequestBody String classEntity, @RequestParam String role)
    {
        if (!"instructor".equals(role)) {
            return "Only instructors can create classes.";
        }

        String classServiceUrl = getServiceUrl("class-service");

        HttpResponse<String> response = Unirest.post(classServiceUrl + "/classes/create")
                .header("Content-Type", "application/json")
                .queryString("role", role)
                .body(classEntity)
                .asString();

        if (response.getStatus() == 200)
        {
            return "Class created successfully: " + response.getBody();
        } else {
            return "Failed to create class: " + response.getBody();
        }
    }

    // Helper method to get service URL from Eureka server
    private String getServiceUrl(String serviceName)
    {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);

        if (instances != null && !instances.isEmpty())
        {
            return instances.get(0).getUri().toString();
        }
        else
        {
            throw new IllegalStateException(serviceName + " service not found");
        }
    }
}
