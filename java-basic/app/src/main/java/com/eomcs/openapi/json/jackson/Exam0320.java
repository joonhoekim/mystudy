// 객체 --> JSON 문자열 : Date 값을 yyyy-MM-dd 형식으로 출력하기
package com.eomcs.openapi.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Exam0320 {
  public static void main(String[] args) throws Exception {


    String jsonStr =
        "{\"no\":100,\"title\":\"Last Java Project\",\"content\":\"Java Web Application\",\"startDate\":\"2024-01-30\",\"endDate\":1715094000000,\"owner\":null,\"members\":[],\"tasks\":[],\"memberNames\":\"\"}";
    // 1) 객체 준비

    ObjectMapper mapper = new ObjectMapper();
    Project project = mapper.readValue(jsonStr, Project.class);

    // project.setNo(100);
    // project.setTitle("Last Java Project");
    // project.setContent("Java Web Application");
    // project.setStartDate(Date.valueOf("2024-1-30"));
    // project.setEndDate(Date.valueOf("2024-5-8"));

    // String jsonStr = mapper.writeValueAsString(project);

    System.out.println(project);
  }
}


