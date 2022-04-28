package com.example.springdoc.service;

import com.example.springdoc.vo.BoardVO;

import java.util.List;

public interface BoardService {

    List<BoardVO> getBoardList();

    List<BoardVO> searchBoardList(BoardVO boardVO);

    BoardVO findBoardById(BoardVO boardVO);

    int registerBoard(BoardVO boardVO);

    int updateBoard(BoardVO boardVO);

    int deleteBoard(BoardVO boardVO);

}
