package com.example.demo3.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    @DeleteMapping("/{email}")
    public String deleteByEmail(@Parameter(name = "email", description = "member email") @PathVariable String email) {
        return "Delete : " + email;
    }

    @DeleteMapping("/member")
    public String deleteByEmail2(@RequestParam String email) {
        return email;
    }
}
