package bitcamp.myapp.vo;

// Caller: CSV 문자열을 받아서 파일에 저장하려는 메서드
// Callee: 도메인 객체(Domain) = 값 객체(Value Object) = 데이터 전송 객체 (DTO) Data Transfer Object
public interface CsvString {

  String toCsvString();
}
