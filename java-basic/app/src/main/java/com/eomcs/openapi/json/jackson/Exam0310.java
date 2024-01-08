// 객체 --> JSON 문자열 : Date 값을 yyyy-MM-dd 형식으로 출력하기
package com.eomcs.openapi.json.jackson;

import java.sql.Date;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Exam0310 {
  public static void main(String[] args) throws Exception {

    // 1) 객체 준비
    Project project = new Project();
    project.setNo(100);
    project.setTitle("Last Java Project");
    project.setContent("Java Web Application");
    project.setStartDate(Date.valueOf("2024-1-30"));
    project.setEndDate(Date.valueOf("2024-5-8"));


    // m1.setRegisteredDate(new Date(System.currentTimeMillis()));

    ObjectMapper mapper = new ObjectMapper();
    // mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

    String jsonStr = mapper.writeValueAsString(project);

    System.out.println(jsonStr);
  }
}


