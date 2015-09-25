package dijkstra;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Dijkstra {

  public static void main(String[] args) {
    List<Point> points = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      char[] chars = {(char) ('A' + i)};
      points.add(new Point(new String(chars)));
    }

    List<Border> borders = new ArrayList<>();
    Map<Border, Integer> weights = new HashMap<>();

    borders.add(new Border(points.get(0), points.get(1)));
    borders.add(new Border(points.get(1), points.get(0)));
    weights.put(borders.get(0), 6);
    weights.put(borders.get(1), 6);

    borders.add(new Border(points.get(0), points.get(2)));
    borders.add(new Border(points.get(2), points.get(0)));
    weights.put(borders.get(2), 3);
    weights.put(borders.get(3), 3);

    borders.add(new Border(points.get(2), points.get(1)));
    borders.add(new Border(points.get(1), points.get(2)));
    weights.put(borders.get(4), 2);
    weights.put(borders.get(5), 2);

    borders.add(new Border(points.get(2), points.get(4)));
    borders.add(new Border(points.get(4), points.get(2)));
    weights.put(borders.get(6), 4);
    weights.put(borders.get(7), 4);

    borders.add(new Border(points.get(2), points.get(3)));
    borders.add(new Border(points.get(3), points.get(2)));
    weights.put(borders.get(8), 3);
    weights.put(borders.get(9), 3);

    borders.add(new Border(points.get(1), points.get(3)));
    borders.add(new Border(points.get(3), points.get(1)));
    weights.put(borders.get(10), 5);
    weights.put(borders.get(11), 5);

    borders.add(new Border(points.get(3), points.get(4)));
    borders.add(new Border(points.get(4), points.get(3)));
    weights.put(borders.get(12), 2);
    weights.put(borders.get(13), 2);

    borders.add(new Border(points.get(3), points.get(5)));
    borders.add(new Border(points.get(5), points.get(3)));
    weights.put(borders.get(14), 3);
    weights.put(borders.get(15), 3);

    borders.add(new Border(points.get(4), points.get(5)));
    borders.add(new Border(points.get(5), points.get(4)));
    weights.put(borders.get(16), 5);
    weights.put(borders.get(17), 5);


    mid(points, borders, weights);

    System.out.println(minRoutes);

  }

  public static void mid(List<Point> points, List<Border> borders, Map<Border, Integer> weights) {

    Point zeroPoint = points.get(0);

    minRoutes.put(new Border(zeroPoint, zeroPoint), 0);

    List<Point> selectedPoints = new ArrayList<>();
    selectedPoints.add(zeroPoint);

    points = points.subList( 1, points.size() );

    // initialization
    for (Border border : borders) {
      Point a = border.getA();
      Point b = border.getB();
      assemblePointLinkers(a, b, pointLinkers);
    }
    Point head = null;

    for (; points.size() > 0; points.remove(0)) {
      head = points.get(0);
      List<Point> linkersOfHead = pointLinkers.get(head);
      List<Point> selectedLinkersOfHead = new ArrayList<>();
      for (Point point : linkersOfHead) {
        if (selectedPoints.contains(point)) {
          selectedLinkersOfHead.add(point);
        }
      }
      Border newMinBorderForHead = new Border(zeroPoint, head);
      int value = 0;
      boolean unassigned = true;
      for (Point point : selectedLinkersOfHead) {
        int min =
            minRoutes.get(new Border(zeroPoint, point)) + weights.get(new Border(point, head));
        if (unassigned) {
          value = min;
          unassigned = false;
        } else {
          value = value > min ? min : value;
        }
      }
      minRoutes.put(newMinBorderForHead, value);
      selectedPoints.add(head);
    }

  }

  private static void assemblePointLinkers(Point a, Point b, Map<Point, List<Point>> pointLinkers) {
    if (!pointLinkers.containsKey(a)) {
      List<Point> lists = new ArrayList<>();
      lists.add(b);
      pointLinkers.put(a, lists);
    } else {
      List<Point> lists = pointLinkers.get(a);
      lists.add(b);
    }
  }

  private static Map<Point, List<Point>> pointLinkers = new HashMap<>();

  private static Map<Border, Integer> minRoutes = new HashMap<>();

}
