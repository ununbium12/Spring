# 스프링 수업

## 2023.04.14


## 2023.04.07


## 2023.03.31

## CH07
> - spring-jdbc : JdbcTemplate 등 JDBC 연동에 필요한 기능 제공
> - 스프링에서 제공하는 트랜잭션 기능을 사용하려면 spring-tx
  모듈이 필요한데, spring-jdbc모듈에 자동 포함
> - tomcat-jdbc: DB 커넥션풀 기능 제공
> - mysql-connector-java : MySQL 연결에 필요한 JDBC 
  드라이버 제공

```
커넥션풀 ? 자바 프로그램에서 DB로 커넥션을 생성하는 시간은 컴퓨터 입장에서 매우 길기 때무에 DB 커넥션을 생성하는 시간이 전체 성능에 영향을 줄 수 있다
```
1. Tomcat JDBC 주요 프로퍼티
---
  - setInitialSize(int)<br>
  커넥션 풀을 초기화
  - setMaxActive(int)<br>
    커넥션 풀에서 가져올 수 있는 최대 커넥션 개수를 지정. 기본값 100
  - setMaxIdle(int)<br>
    커넥션 풀에 유지할 수 있는 최대 커넥션 개수를 지정. 기본값은 maxActive 와 같다
  - setMinIdle(int)<br> 
    커넥션 풀에 유지할 수 있는 최소 커넥션 개수를 지정. 기본값은 initialSize 와 같다
  - setMaxWait(int)<br>
    커넥션 풀에서 커넥션을 가져올 때 대기할 최대 시간을 밀리초 단위로 지정. 기본값은 30000밀리초(30초)
  - setMaxAge(long) <br> 
    최초 커넥션 연결 후 커넥션의 최대 유효 시간을 밀리초 단위로 지정. 기본값은 0 >> 유효 시간이 없음을 의미 |
  - setValidationQuery(String)<br>
    커넥션이 유효한지 검사할 때 사용할 쿼리를 지정. 기본값은 null (null 이면 검사하지 않음). “select 1” 이나 “select 1 from dual” 과 같은 쿼리를 주로 사용
  - setValidationQueryTime(int)<br>
    검사 쿼리의 최대 실행 시간을 초 단위로 지정. 이 시간을 초과하면 검사에 실패한 것으로 간주. 기본값은 -1 >> 0이하로 지정하면 비활성화한다.
---

<br>


## 2023.03.24
## chapter 5 , 6
> 생성됨
<br>

## 2023.03.17
## chapter 4
> CH04 파일 생성 및 CH03 chapter03 내용 합침
<br>

> Dao를 의존형으로 쓴는 이유는 Dao의 형식이 바뀌었을때, 교체하는 시기에 난잡해 질 수 있는 코드를 쉽게 바꾸기 위해서다.
<br>

>Assembler 코드가 있는 이유는 서버를 실행시킬때 지금까지 생성된 서버를 하나의 클래스에서 관리하기 위해서 Assembler class를 만든 것이다.
<br>

> @Bean // Spring 역할
<br>

## 2023.03.10
## chapter 2
> 기본적인 spring을 다루는 내용
> CH02 파일 생성

## chapter 3
> CH03 파일 생성