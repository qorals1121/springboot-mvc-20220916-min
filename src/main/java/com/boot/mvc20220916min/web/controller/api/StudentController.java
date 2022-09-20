package com.boot.mvc20220916min.web.controller.api;

import com.boot.mvc20220916min.web.dto.CMRespDto;
import com.boot.mvc20220916min.web.dto.StudentRespDto;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @GetMapping("/api/v1/students")
    public Object getData() {

        Map<String, Object> responseMap = new HashMap<String, Object>();
        List<StudentRespDto> studentList = new ArrayList<StudentRespDto>();

        StudentRespDto s1 = StudentRespDto.builder()
                .studentCode(20220001)
                .studentName("김준일")
                .studentYear(2)
                .studentAddress("부산 진구")
                .studentPhone("010-9988-1916")
                .build();

        StudentRespDto s2 = StudentRespDto.builder()
                .studentCode(20220002)
                .studentName("김준이")
                .studentYear(4)
                .studentAddress("부산 동래구")
                .studentPhone("010-9999-1234")
                .build();

        studentList.add(s1);
        studentList.add(s2);

        responseMap.put("students", studentList);


        return responseMap;
    }

    @GetMapping("/api/v1/test/students")
    public ResponseEntity<?> getData2() {
        HttpHeaders headers = new HttpHeaders();

        List<StudentRespDto> dtoList = new ArrayList<StudentRespDto>();
        dtoList.add(StudentRespDto.builder().studentCode(20220001).build());
        dtoList.add(StudentRespDto.builder().studentCode(20220002).build());
        dtoList.add(StudentRespDto.builder().studentCode(20220003).build());
        dtoList.add(StudentRespDto.builder().studentCode(20220004).build());

        StringBuilder studentCodeList = new StringBuilder();

        for(StudentRespDto studentRespDto : dtoList) {
            studentCodeList.append(studentRespDto.getStudentCode());
            studentCodeList.append(", ");
        }
        studentCodeList.delete(studentCodeList.length()-2, studentCodeList.length());

        headers.add("student_code_list", studentCodeList.toString());

        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .headers(headers)
                .body(new CMRespDto<>(-1, "HTTP 메소드를 확인해주세요.", dtoList));
        /*
        return new ResponseEntity<>(
                new CMRespDto<>(-1, "HTTP 메소드를 확인해주세요.", dtoList),
                headers,
                HttpStatus.METHOD_NOT_ALLOWED
        );

        위와 아래는 같은 결과를 가져오는데, 위의 builder 방식을 많이 사용한다.
         */
    }
}
