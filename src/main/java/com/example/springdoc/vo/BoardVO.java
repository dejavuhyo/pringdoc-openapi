package com.example.springdoc.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class BoardVO {

    private int id;
    private String title;
    private String contents;
    private String writer;
    private Date regDate;
    private int viewCnt;
    private String searchType;
    private String searchWord;

}
