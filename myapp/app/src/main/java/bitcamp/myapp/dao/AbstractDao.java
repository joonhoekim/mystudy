package bitcamp.myapp.dao;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;


//상속, 제네릭, 리플렉션, json(GSON)
//빌더 패턴, 체이닝 콜
//이러한 복합적인 기술이 들어가 있는 것이다. (신입은 이 정도는 알아야 스프링 프레임워크를 이해하는 것이다.)
public class AbstractDao<T> {

  ArrayList<T> list;

  /* void loadData(String filepath) {
    System.out.println("loadData Test");
    Class<?> clazz = this.getClass();
    System.out.println(clazz.getName());
    System.out.println(clazz.getGenericSuperclass());
    ParameterizedType classInfoWithTypeParameters = (ParameterizedType) clazz.getGenericSuperclass();
    System.out.println(classInfoWithTypeParameters);

    System.out.println(classInfoWithTypeParameters.getActualTypeArguments());
    // 제네릭으로 넘어간 전체 타입파라미터 배열을 요구한다면
//    Type[] typeList = classInfoWithTypeParameters.getActualTypeArguments();
//    for (Type type : typeList) {
//      System.out.println(type.getTypeName());
//    }

// 0번 인덱스만 필요로 한다면
    System.out.println(classInfoWithTypeParameters.getActualTypeArguments()[0].getTypeName());
    Type type = classInfoWithTypeParameters.getActualTypeArguments()[0];
    Class clazz1 = (Class) classInfoWithTypeParameters.getActualTypeArguments()[0];

    // 그래서 결론, 제네릭타입을 받아오려면
    Class<?> genericDataType = (Class) ((ParameterizedType) this.getClass()
        .getGenericSuperclass()).getActualTypeArguments()[0];


  } */

  void loadData(String filepath) {

    try (BufferedReader in = new BufferedReader(new FileReader(filepath))) {

      // 파일에서 JSON 문자열을 모두 읽어서 버퍼에 저장한다.
      StringBuilder strBuilder = new StringBuilder();
      String str;
      while ((str = in.readLine()) != null) {
        strBuilder.append(str);
      }

      // 버퍼에 저장된 JSON 문자열을 가지고 컬렉션 객체를 생성한다.

      Class<?> genericDataType = (Class) ( // 클래스 타입으로 강제캐스팅
          (ParameterizedType) this.getClass() // 이 메서드 호출한 클래스 정보를 알아냄
              .getGenericSuperclass()). //
          getActualTypeArguments()[0]; // 제네릭 타입 알아냄

      list = (ArrayList<T>) new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(
          strBuilder.toString(),
          TypeToken.getParameterized(ArrayList.class, genericDataType));
//      TypeToken.getParameterized(ArrayList.class, T.class)); //이게 안된다! 
//      이 클래스가 다루는 데이터의 클래스 정보를 알아내고 싶은데, 제네릭 문법에서 그것을 지원하지 않는다. (왜? 제네릭은 컴파일러를 위한 규칙이므로..)
//      그것을 해결하기 위해 genericDataType이라는 Class Type의 변수를 만들고 Reflection API를 통해서 받아온 것이다.
      // GSON 및 Reflection API는, 나중에 더 필요하면 더 파보고, 지금은! 쓰는 방법만 알면 된다.
      // 커피 드립백 사용법의 비유를 기억하자. 드립백을 어떻게 써서 커피를 만들어 먹는지를 아는게 먼저고,
      // 지금은 커피 드립백에서 사용되는 필터 종이를 어떻게 만들었는지, 커피 드립백이 어떤 구조로 생겼는지를 파고들지 말자.

    } catch (Exception e) {
      list = new ArrayList<>();
      throw new DaoException("데이터 로딩 중 예외 발생", e);
    }
  }

  //실무 테스트 기법


  void saveData(String filepath) {
    try (BufferedWriter out = new BufferedWriter(new FileWriter(filepath))) {
      out.write(new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list));
    } catch (Exception e) {
      new DaoException("데이터 저장 중 예외 발생", e);
    }
  }

}
