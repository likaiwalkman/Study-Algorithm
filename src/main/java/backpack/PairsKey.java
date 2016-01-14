package backpack;

public class PairsKey {
  private int i;
  private int j;

  public PairsKey(int i, int j) {
    this.i = i;
    this.j = j;
  }

  @Override
  public int hashCode() {
    return i * j;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof PairsKey)) {
      return false;
    } else {
      return ((PairsKey) obj).i == i && ((PairsKey) obj).j == j;
    }
  }
}
