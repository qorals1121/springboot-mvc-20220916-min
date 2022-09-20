package com.boot.mvc20220916min.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter // request 할 때 필요
@Setter // post 받을 때 필요
public class StudentRespDto {
    private int studentCode;
    private String studentName;
    private int studentYear;
    private String studentAddress;
    private String studentPhone;
}
