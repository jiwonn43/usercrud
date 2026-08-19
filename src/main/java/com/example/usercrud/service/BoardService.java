package com.example.usercrud.service;

import com.example.usercrud.dto.BoardCreateRequest;
import com.example.usercrud.dto.BoardResponse;
import com.example.usercrud.entity.Board;
import com.example.usercrud.entity.User;
import com.example.usercrud.repository.BoardRepository;
import com.example.usercrud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public BoardResponse createBoard(BoardCreateRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(RuntimeException::new);

        Board board = new Board(request.getTitle(), request.getContent(), user);

        Board saveBoard = boardRepository.save(board);
        return BoardResponse.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .username(board.getUser().getUsername())
                .build();

    }

        public BoardResponse getBoard(Integer id) {
            Board board = boardRepository.findById(id)
                    .orElseThrow(RuntimeException::new);
            return new BoardResponse(board.getTitle(), board.getContent(), board.getUser().getUsername());

    }
}