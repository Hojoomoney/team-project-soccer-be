package com.rod.api.article;

import com.rod.api.article.model.ArticleDto;
import com.rod.api.article.service.ArticleService;
import com.rod.api.common.component.Messenger;
import com.rod.api.common.component.PageRequestVo;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api/articles")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {
    private final ArticleService service;

    @PostMapping(path = "/save")
    public ResponseEntity<Messenger> save(@RequestBody ArticleDto dto) throws SQLException {
        log.info("입력받은 정보 : {}", dto );
        return ResponseEntity.ok(service.save(dto));
    }
    @GetMapping(path = "/list")
    public ResponseEntity<List<ArticleDto>> findAll() throws SQLException {
        log.info("입력받은 정보 : {}" );
        return ResponseEntity.ok(service.findAll());
    }
    @DeleteMapping(path = "/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam Long id){
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.deleteById(id));
    }
    @GetMapping(path = "/detail")
    public ResponseEntity<Optional<ArticleDto>> findById(@RequestParam Long id){
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping(path = "/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(service.count());
    }
    @GetMapping(path = "/exists/{id}")
    public ResponseEntity<Boolean> existById(@PathVariable Long id){
        return ResponseEntity.ok(service.existById(id));
    }
}
