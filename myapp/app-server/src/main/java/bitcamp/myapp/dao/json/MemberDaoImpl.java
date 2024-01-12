package bitcamp.myapp.dao.json;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import java.util.List;

public class MemberDaoImpl extends AbstractDao<Member> implements MemberDao {

  private int lastKey = 0;

  public MemberDaoImpl(String filepath) {
    super(filepath);
    lastKey = list.getLast().getNo();
  }

  public int indexOf(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      if (this.list.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

  public void add(Member member) {
    member.setNo(++lastKey);
    this.list.add(member);
    saveData();
  }

  public int delete(int no) {
    int index = indexOf(no);
    if (index == -1) {
      return 0;
    }
    this.list.remove(index);
    return 1;
  }

  public int update(Member member) {
    int index = indexOf(member.getNo());
    if (index == -1) {
      return 0;
    }
    this.list.set(index, member);
    saveData();
    return 1;
  }

  public Member findBy(int no) {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return this.list.get(index);
  }

  public List<Member> findAll() {
    return this.list.subList(0, this.list.size());
  }

  @Override
  protected void loadData() {
    super.loadData();
  }

  @Override
  protected void saveData() {
    super.saveData();
  }


}
