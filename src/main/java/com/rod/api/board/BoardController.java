package com.rod.api.board;

import com.rod.api.board.model.BoardDto;
import com.rod.api.board.service.BoardService;
import com.rod.api.common.component.Messenger;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api/boards")
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    private final BoardService service;
    @PostMapping(path = "/save")
    public ResponseEntity<Messenger> save(BoardDto dto) throws SQLException {
        return ResponseEntity.ok(service.save(dto));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Messenger> deleteById(@PathVariable long id){
        service.deleteById(0L);
        return ResponseEntity.ok(new Messenger());
    }
    @GetMapping(path = "/list")
    public ResponseEntity<List<BoardDto>> findAll() throws SQLException {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(path = "/detail")
    public ResponseEntity<Optional<BoardDto>> findById(@RequestParam Long id){
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping(path = "/count")
    public ResponseEntity<Messenger> count(){
        service.count();
        return ResponseEntity.ok(new Messenger());
    }
    @GetMapping(path = "/exists/{id}")
    public ResponseEntity<Messenger> existById(@PathVariable long id){
        service.existById(0L);
        return ResponseEntity.ok(new Messenger());
    }
}