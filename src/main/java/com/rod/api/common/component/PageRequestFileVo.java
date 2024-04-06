package com.rod.api.common.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Builder
@AllArgsConstructor
public class PageRequestFileVo {
    private int page;
    private int size;
    private String type;
    private String keyword;

    private List<?> pageFileDto;

    public PageRequestFileVo() {
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageable(Sort sort){
        return PageRequest.of(page - 1, size, sort);
    }

}
