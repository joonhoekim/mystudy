package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Member;


public class DaoTest extends AbstractDao<Member> { // 여기 이 제네릭타입을 알아내는 방법?

  public static void main(String[] args) {
    DaoTest obj = new DaoTest();
    obj.loadData("app/board.json");

    for (Member member : obj.list) {
      System.out.println(member.getEmail());
    }

  }
}
