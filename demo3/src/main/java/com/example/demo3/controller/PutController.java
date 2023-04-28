package com.example.demo3.controller;

import com.example.demo3.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PutMapping("/member")
    public String putMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();
        putData.entrySet().forEach(map ->{
                sb.append(map.getKey() + " :" + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @PutMapping("/member2")
    public String putMember2(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    @PutMapping("/member3")
    public MemberDto putMember3(@RequestBody MemberDto memberDto) {
        return memberDto;
    }

    @PutMapping("/member4")
    public ResponseEntity<MemberDto> putMember4(@RequestBody MemberDto memberDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
    }
}
