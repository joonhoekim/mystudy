package bitcamp.myapp.menu;

import bitcamp.util.Prompt;


// 계층 구조를 표현하기 위한 객체.
// 각 메뉴그룹 객체는 여러개의 메뉴를 배열의 형태로 가진다.
public class MenuGroup implements Menu { //Menu 인터페이스를 구현하는 클래스 중 하나

  //각 제목들
  String title;
  Menu[] menus = new Menu[10]; // 일단 메뉴를 배열구조로 10개 만들었다.

  int menuSize; //이전 단계의 length처럼 menus 배열에서 몇 개를 채웠는지를 세 주는 인스턴스 필드가 필요하다.

  public MenuGroup(String title) {
    // MenuGroup의 menus 레퍼런스를 통해 메뉴를 추가하거나 더하는 것 또한 당연히 생성자를 거쳐야 하는데
    // 생성시에 String 입력을 강제하며 그것은 메뉴의 타이틀이 된다.
    this.title = title; //받은 아규먼트를 각 개체의 title로 저장한다. (힙영역)


  }


  //오버라이드 주석은 컴파일러에게 인터페이스(또는 슈퍼클래스)의 메서드를 정의한다고 알린다.
  @Override
  public void execute(Prompt prompt) {
    //여기는 이전에 설계했던 것과 동일하게 동작하도록 한다.
    //이전에는 어땠나? 메뉴출력 > 반복문 > 스위치문 > 각각의 동작(핸들러로 이관예정)

    //먼저 전체 메뉴를 뿌린다.
    this.printMenu();

    while (true) {
      //반복문으로 들어가서, 가장 먼저 하는 건 `타이틀명> ` 텍스트를 띄우고 사용자 입력을 받는 것이다.
      String input = prompt.input("%s> ", this.title);

      //이후 사용자가 입력한 것을 검사한다. 우선 공통되는 입력에 대한 행동을 먼저 정의한다.
      if (input.equals("menu")) {
        this.printMenu();
        continue; //여기서 아래는 실행하지 않고 다시 반복문 처음으로 가서 반복한다.
      } else if (input.equals("0")) {
        break; //반복문 밖으로 나간다.
      }

      //이 다음은 숫자로 다룰 것이므로 오입력 검사를 먼저 한다.
      int menuNo = Integer.parseInt(input); //실행할 메뉴 번호 받고,
      if (menuNo < 1 || menuNo > this.menuSize) { //menuSize 변수는 다양한 개수의 메뉴에 대응할 수 있도록 추가되었다.
        System.out.println("메뉴 번호가 옳지 않습니다.");
        continue;
      }

      this.menus[menuNo - 1].execute(prompt); //받은 메뉴 번호를 인덱스에 맞게 1 빼줘서 메서드를 호출한다.

    }

  }

  //메뉴는 추가되거나 삭제된다. 먼저 메뉴 추가를 구현해보자.
  public void add(Menu menu) {//파라미터로는 추가할 메뉴를 받아야 한다.
    //메뉴 배열이 충분하지 않은 경우 추가한다.
    if (menuSize == this.menus.length) { //배열이 꽉 찼다면
      //기존 배열 크기를 50% 증가시키고 복사한다.
      int oldSize = this.menus.length;
      int newSize = oldSize + oldSize >> 2;
      Menu[] arr = new Menu[newSize];

      //배열을 복사한다.
      System.arraycopy(menus, 0, arr, 0, oldSize);
      //다 복사 했으면 arr 레퍼런스가 가리키는 인스턴스 주소를 가져온다.
      this.menus = arr;
    }
    //메뉴 배열이 충분하지 않은 경우 추가한다. - 완료

    this.menus[menuSize++] = menu; //파라미터의 메뉴를 menuGroup 인스턴스에 추가한다.
    // (인덱스는 0부터 시작하므로 추가하고 올려야 해서 후위 연산자를 쓴다.)
    // 이렇게 메뉴를 추가하는 기능이 MenuGroup 클래스에 추가되었다.
  }

  //메뉴는 추가되거나 삭제된다. 이제 삭제를 구현해보자. (여기선 사용되지 않음)
  public void remove(Menu menu) {

    // 파라미터로 받은 것과 일치하는 것이 있는지를 검사하는 메서드를 만든다. (indexOf)
    // indexOf()는 맞는 객체를 찾으면 그 객체의 인덱스를 반환, 없으면 -1을 반환한다.
    int index = this.indexOf(menu);
    if (index == -1) { // 못 찾아서 그대로 리턴.
      return;
    }

    // int 배열 지우듯이 메뉴 객체의 배열을 지운다.
    for (int i = index; i < (this.menuSize - 1); i++) {
      this.menus[i] = this.menus[i + 1];
    }
    this.menus[--this.menuSize] = null;
  }

  int indexOf(Menu menu) {
    for (int i = 0; i < menuSize; i++) {
      if (menu == this.menus[i]) {
        return i;
      }
    }
    return -1;
  }

  private void printMenu() {
    //MenuGroup 인스턴스가 가진 메뉴 배열들을 차례로 출력한다.

    for (int i = 0; i < this.menuSize; i++) {
      System.out.printf("[%d]. %s > %s\n", i + 1, this.title, this.menus[i].getTitle());
    }

    System.out.printf("[0]. %s\n", "이전");

  }

  //TODO 여기서는 메뉴를 더하고 뺴는 기능이 있어야 한다. 메뉴를 하드코딩한 것이 아니기 때문이다.
  //그 기능은 App.java 에서 실행될 것이므로 접근제어자를 public으로 쓴다.

  @Override
  public String getTitle() {
    //return this.title;
    return null;
  }


}
