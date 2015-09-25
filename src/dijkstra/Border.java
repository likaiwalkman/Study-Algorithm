package dijkstra;

public class Border {

  public Border(Point a, Point b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public int hashCode() {
    return a.hashCode() + b.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Border)) {
      return false;
    } else {
      Border border = (Border) obj;
      return border.a.equals(a) && border.b.equals(b);
    }
  }

  public Point getA() {
    return a;
  }

  public void setA(Point a) {
    this.a = a;
  }

  public Point getB() {
    return b;
  }

  public void setB(Point b) {
    this.b = b;
  }

  private Point a;

  private Point b;
}
