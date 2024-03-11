// 프로퍼티 호출 - 의존 객체 주입할 때 즉시 객체 생성하기
package com.eomcs.spring.ioc.ex04.e;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.ex04.Car;
import com.eomcs.spring.ioc.ex04.Engine;

public class Exam01 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = new ClassPathXmlApplicationContext(//
        "com/eomcs/spring/ioc/ex04/e/application-context.xml");

    Car c1 = (Car) iocContainer.getBean("c1");
    Car c2 = (Car) iocContainer.getBean("c2");

    System.out.println(c1.getEngine() == c2.getEngine());

    Engine e1 = (Engine) iocContainer.getBean("e1");
    // 위 라인은 예외가 발생한다. e1이라는 Bean을 찾을 수 없기 때문이다.
    // e1은 프로퍼티 설정 중 만들어서 주입한 객체인데, 이 경우는 주입 이후에는 IoC 컨테이너에 보관되지 않는다.
    // 따라서 그 객체를 선언할 때는 id를 지정하지 않는 것이 혼동을 미리 예방할 수 있다.
  }

}


