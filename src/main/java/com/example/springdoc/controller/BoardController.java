package com.example.springdoc.controller;

import com.example.springdoc.service.BoardService;
import com.example.springdoc.vo.BoardVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

// /swagger-ui/index.html
@Tag(name = "BoardController", description = "게시판 컨트롤러")
@RestController
public class BoardController {

    @Resource
    private BoardService boardService;

    @Operation(operationId = "getBoardList", summary = "게시판 목록 조회", description = "게시판 목록을 조회한다.", tags = {"BoardController"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class)))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class))))
    })
    @GetMapping("/board")
    public ResponseEntity getBoardList() {

        List<BoardVO> getBoardList = boardService.getBoardList();

        if (getBoardList == null) {
            return new ResponseEntity("조회 실패", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(getBoardList, HttpStatus.OK);
    }

    @Operation(operationId = "searchBoardList", summary = "게시글 검색", description = "게시글 제목을 검색한다.", tags = {"BoardController"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class)))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class))))
    })
    @GetMapping("/board/search")
    public ResponseEntity searchBoardList(BoardVO boardVO) {

        List<BoardVO> searchBoardList = boardService.searchBoardList(boardVO);

        if (searchBoardList == null) {
            return new ResponseEntity("검색 실패", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(searchBoardList, HttpStatus.OK);
    }

    @Operation(operationId = "findBoardById", summary = "게시글 상세 조회", description = "게시글을 상세 조회한다.", tags = {"BoardController"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class)))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class))))
    })
    @GetMapping("/board/{id}")
    public ResponseEntity findBoardById(BoardVO boardVO) {

        BoardVO findBoardById = boardService.findBoardById(boardVO);

        if (findBoardById == null) {
            return new ResponseEntity("조회 실패", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(findBoardById, HttpStatus.OK);
    }

    @Operation(operationId = "registerBoard", summary = "게시글 등록", description = "게시글을 등록 조회한다.", tags = {"BoardController"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class)))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class))))
    })
    @PostMapping("/board")
    public ResponseEntity registerBoard(BoardVO boardVO) {

        int registerBoard = boardService.registerBoard(boardVO);
        if (registerBoard == 0) {
            return new ResponseEntity("등록 실패", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity("등록 완료", HttpStatus.OK);
    }

    @Operation(operationId = "updateBoard", summary = "게시글 수정", description = "게시글을 수정한다.", tags = {"BoardController"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class)))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class))))
    })
    @PutMapping("/board")
    public ResponseEntity updateBoard(BoardVO boardVO) {

        int updateBoard = boardService.updateBoard(boardVO);
        if (updateBoard == 0) {
            return new ResponseEntity("수정 실패", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity("수정 완료", HttpStatus.OK);
    }

    @Operation(operationId = "deleteBoard", summary = "게시글 삭제", description = "게시글을 삭제한다.", tags = {"BoardController"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class)))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardVO.class))))
    })
    @DeleteMapping("/board/{id}")
    public ResponseEntity deleteBoard(BoardVO boardVO) {

        int deleteBoard = boardService.deleteBoard(boardVO);
        if (deleteBoard == 0) {
            return new ResponseEntity("삭제 실패", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity("삭제 완료", HttpStatus.OK);
    }

}
