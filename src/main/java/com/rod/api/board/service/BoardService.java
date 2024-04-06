package com.rod.api.board.service;

import com.rod.api.board.model.Board;
import com.rod.api.board.model.BoardDto;
import com.rod.api.common.service.CommandService;
import com.rod.api.common.service.QueryService;

import java.util.Optional;

public interface BoardService extends CommandService<BoardDto>, QueryService<BoardDto> {

    default Board dtoToEntity(BoardDto dto){    //dto 를 entity로 바꾸는 것
        return Board.builder().build();
    }

    default BoardDto entityToDto(Optional<Board> ent){ //entity 를 dto로 바꾸는 것
        return BoardDto.builder().build();
    }

}
