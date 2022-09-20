package com.boot.mvc20220916min.web.controller.api;

import com.boot.mvc20220916min.domain.User;
import com.boot.mvc20220916min.repository.UserRepository;
import com.boot.mvc20220916min.web.dto.UserAddReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
// 예전에 자주 사용하던 방식. 요즘은 RequiredArgs~와 final을 사용한다
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class UserRestController {

    @Autowired
    @Qualifier("a")
    private UserRepository userRepository;

    @GetMapping("/users/{userCode}")
    // 유동적으로 사용하기 위해 PathVariable 사용, 원래 uri에는 대문자를 사용하지 않지만 변수이기 때문에 대문자 사용함
    public ResponseEntity<?> getUser(@PathVariable int userCode) {

        User user = userRepository.findUserByUserCode((userCode));

        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {

        User user = userRepository.findUserByUserId(userId);

        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(UserAddReqDto userAddReqDto) {
        int result = userRepository.save(userAddReqDto.toEntiny());
        if(result == 0) {
            return ResponseEntity.internalServerError().body("데이터 오류(Server)");
        }

        return ResponseEntity.ok().body("사용자 추가 완료");
    }
}
