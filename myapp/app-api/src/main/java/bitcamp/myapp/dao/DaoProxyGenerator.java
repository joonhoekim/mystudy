package bitcamp.myapp.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

public class DaoProxyGenerator {

  private DataInputStream in;
  private DataOutputStream out;
  private Gson gson;

  public DaoProxyGenerator(DataInputStream in, DataOutputStream out) {
    this.in = in;
    this.out = out;
    gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
  }

  public <T> T create(Class<T> clazz, String dataName) {
    return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
        new Class<?>[]{clazz},
        (proxy, method, args) -> { //이 파라미터를 쓰는 functional interface가 특정되므로 가능한 람다문법...
          try {
            out.writeUTF(dataName);
            out.writeUTF(method.getName());
            if (args == null) {
              out.writeUTF("");
            } else {
              out.writeUTF(gson.toJson(args[0]));
            }

            String statusCode = in.readUTF();
            String entity = in.readUTF();

            if (!statusCode.equals("200")) {
              throw new Exception(entity);
            }

            //리턴타입 확인하기
            Type returnType = method.getGenericReturnType();

            if (returnType == void.class) {

              return null;

            } else {

              return gson.fromJson(entity, returnType);

            }
          } catch (Exception e) {
            e.printStackTrace();
          }

          return null;
        });
  }

}
