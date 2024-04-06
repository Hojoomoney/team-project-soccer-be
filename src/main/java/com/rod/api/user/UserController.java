package com.rod.api.user;

import com.rod.api.common.component.MessengerVo;
import com.rod.api.user.model.UserDto;
import com.rod.api.user.repository.UserRepository;
import com.rod.api.user.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/users")
@Slf4j
public class UserController {
    private final UserService service;
    private final UserRepository repository;

    @PostMapping(path = "")
    public ResponseEntity<MessengerVo> save(@RequestBody UserDto user) throws SQLException {
        log.info("Save-회원가입 정보 : " + user);
        return ResponseEntity.ok(MessengerVo.builder()
                .message(service.save(user).toString())
                .build());
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<MessengerVo> deleteById(@PathVariable long id){
        service.deleteById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping(path = "")
    public ResponseEntity<List<UserDto>> findAll(Pageable pageable) throws SQLException {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<MessengerVo> findById(@PathVariable Long id){
        service.findById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping(path = "/count")
    public ResponseEntity<MessengerVo> count(){
        service.count();
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping(path = "/exists/{id}")
    public ResponseEntity<MessengerVo> existById(@PathVariable long id){
        service.existById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }

}
