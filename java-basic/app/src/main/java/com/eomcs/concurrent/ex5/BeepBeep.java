// sychronized 인스턴스 메서드 - 적용
package com.eomcs.concurrent.ex5;

import java.awt.Toolkit;

public class BeepBeep {
  public static void main(String[] args) throws InterruptedException {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    for (int i = 0; i < 50; i++) {
      toolkit.beep();
      Thread.sleep(100);
    }

  }
}
