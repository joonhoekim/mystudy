package bitcamp.menu;

import bitcamp.util.Stack;

public abstract class AbstractMenu implements Menu {

  protected String title;
  protected Stack<String> breadcrumb;

  //스택활용하기


  public AbstractMenu(String title, Stack<String> breadcrumb) {
    this.title = title;
    this.breadcrumb = breadcrumb;
  }

//  public AbstractMenu(String title) {
//    this.title = title;
//  }

  public String getMenuPath() {
    return String.join("/", breadcrumb.toArray(new String[0]));
  }

  @Override
  public String getTitle() {
    return this.title;
  }

//  public void setTitle(String title) {
//    this.title = title;
//  }
}
