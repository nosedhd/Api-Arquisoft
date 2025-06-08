package com.universidad.luisCruz.controller;

import com.universidad.luisCruz.model.AgifyInit;
import com.universidad.luisCruz.Log.ComparationRequest;
import com.universidad.luisCruz.Log.ComparationReply;
import com.universidad.luisCruz.service.ApiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/names")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
    @GetMapping("/sum")
    public Integer suma(@RequestParam Integer a, @RequestParam Integer b) {
        return apiService.suma(a, b);
    }
    @GetMapping("/age")
    public AgifyInit getAge(@RequestParam String name) {
        return apiService.ageAndCount(name);
    }
    @GetMapping("/compare")  // Cambiado a GET
    public ComparationReply compareAge(
            @RequestParam String name,
            @RequestParam Integer realAge) {

        AgifyInit response = apiService.ageAndCount(name);
        ComparationReply result = new ComparationReply();
        result.setName(response.getName());
        result.setEstimatedAge(response.getAge());
        result.setRealAge(realAge);
        result.setRightGuess(response.getAge() == realAge);
        return result;
    }
}