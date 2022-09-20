package com.boot.mvc20220916min.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDataDto {
    private String value1;
    private int value2;
    private boolean value3;
}
