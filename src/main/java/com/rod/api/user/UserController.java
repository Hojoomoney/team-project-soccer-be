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

    public Messenger join(Scanner sc) throws SQLException {
        System.out.println("ID, 비번, 이름, 전화번호, 직업, 키, 몸무게를 순서대로 입력하세요.");
        userService.save(User.builder()
                .username(sc.next())
                .password(sc.next())
                .name(sc.next())
                .phone(sc.next())
                .job(sc.next())
                .height(sc.next())
                .weight(sc.next())
                .build());
        return Messenger.SUCCESS;
    }

    public Messenger createMemberTable() throws SQLException {
        return userService.createMemberTable();
    }

    public String deleteMemberTable() throws SQLException {
        return userService.deleteMemberTable();
    }

    public List<User> findAll() throws SQLException {
        return userService.findAll();
    }
}
