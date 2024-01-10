package bitcamp.myapp.dao;

// 이 클래스의 목적
// - RuntimeException 기능 확장이 아님
// - 예외가 발생했을 때, 예외 클래스의 `이름`으로 예외가 어디서 발생했는지 `바로` 알아내려는 것이다.
// - 그리고, 혹시라도 기능확장이 필요한 경우에 이 코드만 수정하면 되는 장점이 생긴다.
// 실제로 이러한 목적의 네이밍만 달리한 예외를 많이 만든다.
public class DaoException extends RuntimeException {

  public DaoException() {
  }

  public DaoException(String message) {
    super(message);
  }

  public DaoException(String message, Throwable cause) {
    super(message, cause);
  }

  public DaoException(Throwable cause) {
    super(cause);
  }

  public DaoException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
