package bitcamp.myapp.dao.json;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import java.util.List;

public class AssignmentDaoImpl extends AbstractDao<Assignment> implements AssignmentDao {

  private int lastKey = 0;


  public AssignmentDaoImpl(String filepath) {
    super(filepath);
    lastKey = list.getLast().getNo();
  }

  @Override
  public void add(Assignment assignment) {
    assignment.setNo(++lastKey);
    this.list.add(assignment);
    saveData();
  }

  @Override
  public int delete(int no) {
    int index = indexOf(no);
    if (index == -1) {
      return 0;
    }
    list.remove(index);
    saveData();
    return 1;
  }

  @Override
  public List<Assignment> findAll() {
    return this.list.subList(0, this.list.size());
  }

  @Override
  public Assignment findBy(int no) {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return this.list.get(index);
  }

  @Override
  public int update(Assignment assignment) {
    int index = indexOf(assignment.getNo());
    if (index == -1) {
      return 0;
    }
    list.set(index, assignment);
    saveData();
    return 1;
  }

  public int indexOf(int no) {

    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

}
