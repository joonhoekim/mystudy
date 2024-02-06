// JDBC 프로그래밍 - DBMS에 SQL문 보내기 : delete, FK 가 참조하는 데이터 지우기
package com.eomcs.jdbc.ex1;

import java.sql.DriverManager;

public class Exam0361 {

  public static void main(String[] args) throws Exception {
    try (java.sql.Connection con = DriverManager.getConnection(
        // "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        "jdbc:mysql://localhost:3306/studydb", "study", "Bitcamp!@#123");
        java.sql.Statement stmt = con.createStatement();

    ) {

      // 부모 테이블의 데이터를 지우려면,
      // 부모 테이블의 데이터를 참조하는 자식 테이블의 데이터를 먼저 지워야 한다.
      //
      // => 게시글을 참조하는 첨부 파일 데이터를 먼저 지운다.
      int count = stmt.executeUpdate("delete from x_board_file where board_id = 2");
      System.out.printf("x_board_file 테이블 : %d 개 삭제 성공!\n", count);

      // => 부모 테이블의 데이터를 지운다.
      int count2 = stmt.executeUpdate("delete from x_board where board_id = 2");
      System.out.printf("x_board 테이블 : %d 개 삭제 성공!\n", count2);

      // Exception in thread "main" java.sql.SQLIntegrityConstraintViolationException: Cannot delete
      // or update a parent row: a foreign key constraint fails (`studydb`.`x_board_file`,
      // CONSTRAINT `fk_board_file` FOREIGN KEY (`board_id`) REFERENCES `x_board` (`board_id`))
      // at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:118)
      // at
      // com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
    }
  }
}


