package com.example.demo3.controller;

import com.example.demo3.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    @GetMapping("/name")
    public String getName() {
        return "Spring";
    }

    @GetMapping("/variable/{variable}") // {...} 안의 변수와 (@PathVariable String ...) 의 변수가 같아야한다.
    public String getVariable(@PathVariable String variable) {
        return variable;
    }

    @GetMapping("/info/{userId}")
    public String getUserInfo(@PathVariable String userId) {
        // DB userId
        return userId;
    }

    @GetMapping("/info2/{id}")
    public String getUserInfo2(@PathVariable("id") String userId) {
        return userId;
    }

    @GetMapping("/request1")
    public String getRequestParam(@RequestParam String name, @RequestParam String email) {
        return name +" "+ email;
    }

    @GetMapping("/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey()+" : "+ map.getValue() +"\n");
        });
        return sb.toString();
    }

    @GetMapping("/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }
}
