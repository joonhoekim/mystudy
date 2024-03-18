package bitcamp.app1;

import java.beans.PropertyEditorSupport;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice //This always give an advice to Page Controllers.
public class GlobalInitialBinder extends PropertyEditorSupport {

  @InitBinder
  // => 메서드 이름은 마음대로.
  // => 작업하는데 필요한 값이 있다면 파라미터로 선언하라.
  public void initBinder(WebDataBinder binder) {
    System.out.println("Hi I am Global Initiali Binder. I am super Advisor...");
    // 프로퍼티 에디터를 등록하려면 그 일을 수행할 객체(WebDataBinder)가 필요하다.
    // request handler 처럼 아규먼트를 선언하여
    // 프론트 컨트롤러에게 달라고 요청하라.

    //String ===> java.util.Date 프로퍼티 에디터 준비
    DatePropertyEditor propEditor = new DatePropertyEditor();

    // WebDataBinder에 프로퍼티 에디터 등록하기
    binder.registerCustomEditor(
        java.util.Date.class, // String을 Date 타입으로 바꾸는 에디터임을 지정한다.
        propEditor // 바꿔주는 일을 하는 프로퍼티 에디터를 등록한다.
    );

    // WebDataBinder에 프로퍼티 에디터 등록하기
    binder.registerCustomEditor(
        Car.class, // String을 Car 타입으로 바꾸는 에디터임을 지정한다.
        new CarPropertyEditor() // 바꿔주는 일을 하는 프로퍼티 에디터를 등록한다.
    );

    // WebDataBinder에 프로퍼티 에디터 등록하기
    binder.registerCustomEditor(Engine.class, // String을 Engine 타입으로 바꾸는 에디터임을 지정한다.
        new EnginePropertyEditor() // 바꿔주는 일을 하는 프로퍼티 에디터를 등록한다.
    );
  }
}
