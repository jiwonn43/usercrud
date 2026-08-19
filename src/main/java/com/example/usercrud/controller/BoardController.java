package com.example.usercrud.controller;

import com.example.usercrud.dto.BoardCreateRequest;
import com.example.usercrud.dto.BoardResponse;
import com.example.usercrud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoardResponse createBoard(@RequestBody BoardCreateRequest request) {
        return boardService.createBoard(request);
    }

    @GetMapping("/{board-id}")
    public BoardResponse getBoard(@PathVariable("board-id") Integer id) {
        return boardService.getBoard(id);
    }
}