package bitcamp.myapp.vo;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable, CsvString {

  private String title;
  private String content;
  private String writer;
  private Date createdDate;

  //toCsvString으로 정보를 다루는 클래스가 그 정보를 가공하도록 하는 위치 선정이 GRASP 에서 Information Expert 적용이다.
  @Override
  public String toCsvString() {
    return String.format("%s,%s,%s,%d", title, content, writer, createdDate.getTime());
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}
