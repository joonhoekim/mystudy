package bitcamp.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStream extends FileInputStream {

  public DataInputStream(String name) throws FileNotFoundException {
    super(name);
  }


  public short readShort() throws IOException {
    return (short) (read() << 8 | read());
  }

  public int readInt() throws IOException {
    return (read() << 32 | read() << 16 | read() << 8 | read() << 0);
  }

  public int readLong() throws IOException {
    return (((long) read() << 48) |
        ((long) read() << 40) |
        ((long) read() << 32) |
        ((long) read() << 24) |
        (long) (read() << 16) |
        (long) (read() << 8) |
        (long) (read() << 0));

  }
}
