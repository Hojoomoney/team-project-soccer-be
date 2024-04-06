package com.rod.api.article;

import com.rod.api.article.service.ArticleService;
import com.rod.api.common.component.MessengerVo;
import com.rod.api.common.component.PageRequestVo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService service;

    @PostMapping(path = "")
    public ResponseEntity<MessengerVo> save(PageRequestVo vo) throws SQLException {
        service.save(null);
        return ResponseEntity.ok(new MessengerVo());
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<MessengerVo> deleteById(@PathVariable long id){
        service.deleteById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping(path = "")
    public ResponseEntity<MessengerVo> findAll(PageRequestVo vo) throws SQLException {
        service.findAll();
        return ResponseEntity.ok(new MessengerVo());
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
