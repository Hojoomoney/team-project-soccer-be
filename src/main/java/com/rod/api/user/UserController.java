package com.rod.api.user;

import com.rod.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    @PostMapping("/api/login")
    public Map<String, ?> username(@RequestBody Map<?, ?> map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        System.out.println("리퀘스트가 가져온 이름 : " + username);
        System.out.println("리퀘스트가 가져온 비밀번호 : " + password);
        Map<String, String> respMap = new HashMap<>();
        respMap.put("username", username);
        respMap.put("password", password);
        return respMap;
    }

    @PostMapping(path = "/api/users")
    public Map<String, ?> join(@RequestBody Map<?, ?> map){
        Map<String, Messenger> respMap = new HashMap<>();
        User user = userRepository.save(User.builder()
                .username((String) map.get("username"))
                .password((String) map.get("password"))
                .email((String) map.get("email"))
                .name((String) map.get("name"))
                .phone((String) map.get("phone"))
                .job((String) map.get("job"))
                .build());
        System.out.println("DB 에 저장된 User 정보 : " + user);
        respMap.put("result", Messenger.SUCCESS);
        return respMap;
    }

}
