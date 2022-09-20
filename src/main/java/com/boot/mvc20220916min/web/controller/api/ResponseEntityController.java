package com.boot.mvc20220916min.web.controller.api;

import com.boot.mvc20220916min.web.dto.CMRespDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ResponseEntityController {

    @GetMapping("/api/v1/entity/data1")
    public ResponseEntity<?> getData() {

        return new ResponseEntity<String>("responseEntity 응답", HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/api/v1/entity/data2")
    public ResponseEntity<?> getData2() {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("test-token", UUID.randomUUID().toString());

        return new ResponseEntity<String>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/v1/entity/data3")
    public ResponseEntity<?> getData3() {
        MultiValueMap<String, String> headers = new HttpHeaders();

        headers.add("test-token1", UUID.randomUUID().toString());
        headers.add("test-token2", UUID.randomUUID().toString());
        headers.add("test-token3", UUID.randomUUID().toString());

        return new ResponseEntity<String>("test", headers, HttpStatus.OK);
    }

    @GetMapping("/api/v1/entity/data4")
    public ResponseEntity<?> getData4() {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("test-token1", UUID.randomUUID().toString());
        headers.add("test-token2", UUID.randomUUID().toString());
        headers.add("test-token3", UUID.randomUUID().toString());

        return new ResponseEntity<>(
                new CMRespDto<>(1, "전송 성공", "testdata"),
                headers,
                HttpStatus.OK);
    }

    @GetMapping("/api/v1/entity/data5")
    public ResponseEntity<?> getData5() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("token1", "aaaa1111");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new CMRespDto<>(1, "메세지", "test"));
    }
}
