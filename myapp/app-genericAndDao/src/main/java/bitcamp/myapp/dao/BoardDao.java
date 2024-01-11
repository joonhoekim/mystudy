package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Board;
import java.util.List;

public class BoardDao extends AbstractDao {

  public BoardDao(String filepath) {
    super(filepath);
  }

  public void add(Board board) {
    this.list.add(board);
    saveData();
  }

  public int delete(int no) { //returns the number of deleted items.
    if (no < 0 || no >= list.size()) {
      //Out of index
      return 0;
    }
    this.list.remove(no);
    return 1;
  }

  public List<Board> findAll() {
    return this.list.subList(0, list.size());
  }

  public Board findBy(int no) {
    if (no < 0 || no >= list.size()) {
      return null;
    }
    return (Board) list.get(no); // ?
  }

  public int update(int no, Board board) {
    if (no < 0 || no >= list.size()) {
      return 0;
    }
    list.set(no, board);
    return 1;
  }
}
