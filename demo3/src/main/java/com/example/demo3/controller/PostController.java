package com.example.demo3.controller;

import com.example.demo3.dto.MemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

//    @PostMapping("/domain") // 두가지 방법다 쓸 수 있다.
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post Api";
    }

    @Operation(summary = "member post", description = "member post example")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "정상요청",
                    content = @Content(schema =
                        @Schema(implementation = MemberDto.class)
                    )),
            @ApiResponse(responseCode = "400", description = "필수파라미터 누락")
    })
    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " :" + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @PostMapping("/member2")
    public String postMember2(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}
