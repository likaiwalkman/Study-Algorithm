package lcs;

import java.util.LinkedList;
import java.util.List;
/**
 * Longest Commons Sequence
 * @author victor
 *
 */
public class LCS {

  public static void main(String[] args) {
    List<Character> a = new LinkedList<Character>();
    a.add('c');
    a.add('n');
    a.add('b');
    a.add('l');
    a.add('o');
    a.add('g');
    a.add('s');
    List<Character> b = new LinkedList<Character>();
    b.add('b');
    b.add('e');
    b.add('l');
    b.add('o');
    b.add('n');
    b.add('g');
    int rs = lcs(a,b);
    System.out.println(rs);
  }

  public static int lcs(List<Character> a, List<Character> b) {
    if (a.size() == 0 || b.size() == 0) {
      return 0;
    } else {
      if (a.get(a.size() - 1).equals(b.get(b.size() - 1))) {
        return lcs(a.subList(0, a.size()-1), b.subList(0, b.size()-1)) + 1;
      } else {
        int temp1 = lcs(a.subList(0, a.size()), b.subList(0, b.size()-1));
        int temp2 = lcs(a.subList(0, a.size()-1), b.subList(0, b.size()));
        return temp1 > temp2 ? temp1 : temp2;
      }
    }

  }
}
