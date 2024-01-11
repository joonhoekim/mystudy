package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Board;
import java.util.List;

public interface BoardDao {


  public void add(Board board);

  public int delete(int no);

  public List<Board> findAll();

  public Board findBy(int no);

  public int update(Board board);

  // private int indexOf(int no)

}
