package com.rod.api.user;

import com.rod.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.SQLException;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    @PostMapping("/api/login")
    public Map<String, ?> username(@RequestBody Map<?, ?> map){
        Map<String, Messenger> respMap = new HashMap<>();
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        User optUser = userRepository.findByUsername(username).orElse(null);
        if(optUser == null){
            respMap.put("message", Messenger.FAIL);
        } else if(!password.equals(optUser.getPassword())){
            respMap.put("message", Messenger.WRONG_PASSWORD);
        } else {
            respMap.put("message", Messenger.SUCCESS);
        }
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
        respMap.put("message", Messenger.SUCCESS);
        return respMap;
    }

}
