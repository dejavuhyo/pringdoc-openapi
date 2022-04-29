# Springdoc Openapi

## 1. 설명
게시판(Board) Rest API CRUD 예제이다. 포트는 8081을 사용한다.

## 2. 개발환경

* OpenJDK 11

* spring-boot 2.6.7

* PostgreSQL 13.5

* log4jdbc 1.16

* logback

* openapi 1.6.8

## 3. DB (PostgreSQL)

* /db/table.sql

## 4. Rest API 실행

### 1) 조회

* GET
  - 목록 조회: http://localhost:8081/board
  - 상세 조회: http://localhost:8081/board/1

### 2) 등록

* POST
  - http://localhost:8081/board

* Params
  - title=제목
  - contents=내용
  - writer=작성자

### 3) 수정

* PUT
  - http://localhost:8081/board

* Params
  - title=수정제목
  - contents=수정내용
  - writer=수정작성자

### 4) 삭제

* DELETE
  - http://localhost:8081/board/1


## 5. OpenAPI UI 실행

* http://localhost:8081/swagger-ui/index.html
