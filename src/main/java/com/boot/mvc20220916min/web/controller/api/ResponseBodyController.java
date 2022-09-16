package com.boot.mvc20220916min.web.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j // Logger 대신 사용 가능. lombok 내장
@RestController // 그냥 controller와의 차이는 restcontroller는 responsebody가 모두 붙어있는 형태인 것이다.
public class ResponseBodyController {

    //Logger LOGGER = LoggerFactory.getLogger(getClass());

    @GetMapping("/api/text") //@RequestParam 으로 명시해주는 것
    public String textGetReq(@RequestParam String value, @RequestParam int num) {
        return "파라미터 값: " + value + ", " + num;
    }

    @PostMapping("/api/text")
    public String textPostReq(@RequestParam String name, int age) {
        log.info("name: {}, {}, {}, {}", name, age, name, age);
        log.info("age: {}", age);
        return "name: " + name + ", age : " + age;
    }

    @PutMapping("/api/text")
    public String textPutReq() {
        log.info("put Request");
        return "풋 요청에 대한 응답";
    }

    @DeleteMapping("/api/text")
    public String textDeleteReq() {
        log.info("delete Request");
        return "딜리트 요청에 대한 응답";
    }

}
