package com.boot.mvc20220916min.web.controller.api;

import com.boot.mvc20220916min.web.dto.AddPostReqDto;
import com.boot.mvc20220916min.web.dto.CMRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class RequestTestController {

    @PostMapping ("/api/v1/rp/post")
    public ResponseEntity<?> postData(@RequestParam String title,
                                      @RequestParam String writer,
                                      @RequestParam String content) {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("title", title);
        map.put("writer", writer);
        map.put("content", content);

        return ResponseEntity.ok(new CMRespDto(1, "게시글 작성 완료", map));
    }

    @PostMapping ("/api/v1/dto/post")
    public ResponseEntity<?> postData2(AddPostReqDto addPostReqDto) {

       log.info("{}", addPostReqDto);

        return ResponseEntity.ok(new CMRespDto(1, "데이터 전송 성공", addPostReqDto));

    }

    @PostMapping ("/api/v1/file/post")
    public ResponseEntity<?> postData3(AddPostReqDto addPostReqDto) {

        log.info("{}", addPostReqDto);
        List<String> fileNames = new ArrayList<String>();

        String fileName1 = addPostReqDto.getFile().getOriginalFilename();
        fileNames.add(fileName1);

        if(addPostReqDto.getFiles() != null) {
            String fileName2 = addPostReqDto.getFiles().get(0).getOriginalFilename();
            String fileName3 = addPostReqDto.getFiles().get(1).getOriginalFilename();

            fileNames.add(fileName2);
            fileNames.add(fileName3);
        }

        return ResponseEntity.ok(new CMRespDto(1, "게시글 작성 완료", fileNames));

    }

    @PostMapping ("/api/v1/json/post")
    public ResponseEntity<?> postData4(@RequestBody AddPostReqDto addPostReqDto) {

        log.info("{}", addPostReqDto);

        return ResponseEntity.ok(new CMRespDto(1, "Json으로 작성 완료", addPostReqDto));

    }

    @DeleteMapping("/api/v1/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable int id) {
        log.info("삭제할 게시글 번호 : ({})", id);

        return ResponseEntity.ok(new CMRespDto<>(1, "메세지 전송 선공", deletePost(0)));
    }
}
