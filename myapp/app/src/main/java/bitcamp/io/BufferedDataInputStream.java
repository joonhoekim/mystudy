package bitcamp.io;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedDataInputStream extends DataInputStream {

  private final byte[] buffer = new byte[8192];
  int size;
  int cursor;

  public BufferedDataInputStream(String name) throws FileNotFoundException {
    super(name);
  }

  @Override
  public int read() throws IOException {
    if (cursor == size) {
      cursor = 0;
      size = super.read(buffer); //파일 읽어서 버퍼에 넣고 넣은 개수 반환된거 size에 넣음
      if (size == -1) {
        return -1;
      }
    }
    return buffer[cursor++] & 0xFF; // 주의!
  }

  @Override
  public int read(byte[] arr) throws IOException {
    for (int i = 0, count = 0; i < arr.length; i++, count++) {
      int b = read();
      if (b == -1) {

      }
    }
    return super.read(arr);
  }

  @Override
  public int read(byte[] arr, int off, int len) throws IOException {
    for (int i = off, count = 0; count < len; i++, count++) {
      int b = read();
      if (b == -1) { //이거 예외로 바꾸면 여기가 다 catch문으로 가야겠는걸?
        return count > 0 ? count : -1; //len보다 읽을게없을떄 몇개나읽었는지 반환한다.
      }
      arr[i] = (byte) b;
    }
    return len; //몇개나읽었는지int로반환한다. 다읽은경우는 len이겠지.
  }
}
