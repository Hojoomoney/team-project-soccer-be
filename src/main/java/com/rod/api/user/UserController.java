package com.rod.api.user;

import com.rod.api.common.component.Messenger;
import com.rod.api.user.model.UserDto;
import com.rod.api.user.repository.UserRepository;
import com.rod.api.user.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping( "/save")
    public ResponseEntity<Messenger> save(@RequestBody UserDto dto) throws SQLException {
        log.info("입력받은 정보 : {}", dto );
        return ResponseEntity.ok(service.save(dto));

    }


    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> findAll() throws SQLException {
        log.info("입력받은 정보 : {}" );
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/detail")
    public ResponseEntity<Optional<UserDto>> findById(@RequestParam Long id) {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.findById(id));
    }



    @PutMapping("/modify")
    public ResponseEntity<Messenger> modify(@RequestBody UserDto param) {
        log.info("입력받은 정보 : {}", param );
        return ResponseEntity.ok(service.modify(param));
    }


    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam Long id) {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.deleteById(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(service.count());

    }

    @PostMapping("/search")
    public ResponseEntity<List<UserDto>> findUsersByName(@RequestBody UserDto param) {
        //log.info("입력받은 정보 : {}", name );
        return ResponseEntity.ok(service.findUsersByName(param.getName()));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Messenger> login(@RequestBody UserDto param) {
        log.info("입력받은 정보 : {}", param );
        return ResponseEntity.ok(service.login(param));
    }
    @GetMapping(path = "/exists/{id}")
    public ResponseEntity<Boolean> existById(@PathVariable Long id){
        return ResponseEntity.ok(service.existById(id));
    }

}
