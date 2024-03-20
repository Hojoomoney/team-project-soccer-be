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

    @PostMapping("/login")
    public Map<String, ?> username(@RequestBody Map<String, ?> map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        System.out.println("리퀘스트가 가져온 이름 : " + username);
        System.out.println("리퀘스트가 가져온 비밀번호 : " + password);
        Map<String, String> respMap = new HashMap<>();
        respMap.put("username", username);
        respMap.put("password", password);
        return respMap;
    }

}
