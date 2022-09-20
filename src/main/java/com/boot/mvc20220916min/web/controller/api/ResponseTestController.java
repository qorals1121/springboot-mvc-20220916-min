package com.boot.mvc20220916min.web.controller.api;

import com.boot.mvc20220916min.web.dto.ResponseDataDto;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller // 일일이 ResponseBody를 달아주기 귀찮을 때 (view들만 있는 페이지) Controller 대신 RestController를 달아준다
//그래서 보통 view만 있는 Controller, 그냥 Controller 파일을 따로 만들어준다.
public class ResponseTestController {

    @ResponseBody // 일반 리스폰스 형태로 변환하는 것
    @GetMapping("/api/v1/data1")
    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("이름", "김준일");
        data.put("연락처", "010-9988-1916");

        return data;
    }

    @ResponseBody
    @GetMapping("/api/v1/data2")
    public ResponseDataDto getData2() {

        return ResponseDataDto.builder()
                .value1("그냥 문자열")
                .value2(1000)
                .value3(true)
                .build();

    }

    @ResponseBody
    @GetMapping("/api/v1/data3")
    public Object getData3() { // 꼭 Dto로 받지않아도 되고 Object로 받아도 된다.

        return ResponseDataDto.builder()
                .value1("그냥 문자열2")
                .value2(2000)
                .value3(false)
                .build();

    }
}
