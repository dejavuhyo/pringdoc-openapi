package com.example.springdoc.mapper;

import com.example.springdoc.vo.BoardVO;

import java.util.List;

public interface BoardMapper {

    List<BoardVO> getBoardList();

    List<BoardVO> searchBoardList(BoardVO boardVO);

    BoardVO findBoardById(BoardVO boardVO);

    int registerBoard(BoardVO boardVO);

    int updateBoard(BoardVO boardVO);

    int deleteBoard(BoardVO boardVO);

}
