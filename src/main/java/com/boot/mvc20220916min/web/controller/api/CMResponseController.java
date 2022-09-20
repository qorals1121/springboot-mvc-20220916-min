package com.boot.mvc20220916min.web.controller.api;

import com.boot.mvc20220916min.web.dto.CMRespDto;
import com.boot.mvc20220916min.web.dto.StudentRespDto;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.ArrayList;
import java.util.List;

/*
    CM(Commit Massage)
    CMResponse
    Commit 메세지를 포함한 응답
 */
@RestController
public class CMResponseController {

    @GetMapping("/api/v1/cm/data1")
    public CMRespDto<?> getData() {

        return new CMRespDto<String>(1, "데이터 응답 성공", "테스트 데이터");
    }

    @GetMapping("/api/v1/cm/data2")
    public CMRespDto<?> getData2() {

        return new CMRespDto<Boolean>(-1, "데이터 응답 실패", false);
    }

    @GetMapping("/api/v1/cm/data3")
    public CMRespDto<?> getData3() {
        List<StudentRespDto> dtoList = new ArrayList<StudentRespDto>();
        dtoList.add(StudentRespDto.builder().studentCode(1).build());
        dtoList.add(StudentRespDto.builder().studentCode(2).build());
        dtoList.add(StudentRespDto.builder().studentCode(3).build());
        dtoList.add(StudentRespDto.builder().studentCode(4).build());

        return new CMRespDto<>(1, "학생 정보 리스트 데이터입니다", dtoList); // <>안을 비워두면 자동으로 자료형을 변환한다
    }


}
