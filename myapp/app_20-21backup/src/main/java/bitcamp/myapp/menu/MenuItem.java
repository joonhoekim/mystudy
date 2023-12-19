package bitcamp.myapp.menu;

import bitcamp.util.Prompt;

// Composite 패턴에서 leaf 역할을 수행하는 클래스
// Leaf?
// - 하위 항목을 포함하지 않는 말단 객체
// - 예를들어 파일시스템에서 '파일'에 해당한다.
public class MenuItem implements Menu {
    String title;
    MenuHandler menuHandler;


    public MenuItem(String title, MenuHandler menuHandler) {
        this.title = title;
        this.menuHandler = menuHandler;
    }

    @Override
    public void execute(Prompt prompt) { //execute()를 실행하면,

        if (this.menuHandler != null) { //생성자에서 파라미터로 받아온 메뉴핸들러 객체가 있으면,
            this.menuHandler.action(this); //현재의 menu 객체를 파라미터로 갖는 action() 메서드를 호출한다.
        }
    }

    @Override
    public String getTitle() {  //인스턴스 필드로 있는 title 변수를 필요로 하는 경우 받는 메서드

        return this.title;
    }
}
