import tester.*;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

class Point {
  int x, y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  double distance(Point other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
  }
}

class PointCompare implements Comparator<Point> {
  public int compare(Point p1, Point p2) {
    if(p1.y > p2.y) {
      return 1;
    }
    else if(p1.y < p2.y) {
      return -1;
    }
    else {
      if(p1.x > p2.x) { return 1; }
      else if(p1.x < p2.x) { return -1; }
      else { return 0; }
    }
  }
}

class PointDistanceCompare implements Comparator<Point> {
  public int compare(Point p1, Point p2) {
    double d1 = p1.distance(new Point(0, 0));
    double d2 = p2.distance(new Point(0, 0));
    if(d1 > d2) { return 1; }
    else if (d1 < d2) { return -1; }
    else { return 1; }
  }
}

class StringCompare implements Comparator<String> {
  public int compare(String p1, String p2) {
    return p1.compareTo(p2);
  }
}

class StringLengthCompare implements Comparator<String> {
  public int compare(String s1, String s2) {
    if(s1.length() > s2.length()) {
      return 1;
    }
    else if(s1.length() < s2.length()) {
      return -1;
    }
    else {
      return 0;
    }
  }
}

class BooleanCompare implements Comparator<Boolean> {
  public int compare(Boolean b1, Boolean b2) {
    if(b1 == b2) { return 0; }
    else if(b1 && !b2) { return 1; }
    else { return -1; }
  }
}



class CompareLists {
  <E> E minimum(List<E> list, Comparator<E> c) {
    if(list.size() == 0) { return null; }
    E min = list.get(0);
    for(E e: list) {
      if(c.compare(e, min) < 0) { min = e; }
    }
    return min;
  }

  <E> E minimum(E[] es, Comparator<E> c) {
    if(es.length == 0) { return null; }
    E min = es[0];
    for(E e: es) {
      if(c.compare(e, min) < 0) { min = e; }
    }
    return min;
  }

  <E> List<E> greaterThan(List<E> list, Comparator<E> c, E e) {
    List<E> toReturn = new ArrayList<>();
    for(E elt: list) {
      if(c.compare(elt, e) > 0) {
        toReturn.add(elt);
      }
    }
    return toReturn;
  }

  <E> boolean inOrder(List<E> list, Comparator<E> c) {
    for(int i = 0; i < list.size() - 1; i += 1) {
      if(c.compare(list.get(i), list.get(i + 1)) > 0) {
        return false;
      }
    }
    return true;
  }

  <E> boolean inOrder(E[] es, Comparator<E> c) {
    for(int i = 0; i < es.length - 1; i += 1) {
      if(c.compare(es[i], es[i + 1]) > 0) {
        return false;
      }
    }
    return true;
  }

  <E> List<E> merge(Comparator<E> c, List<E> es1, List<E> es2) {
    List<E> merged = new ArrayList<E>();
    int index1 = 0;
    int index2 = 0;
    for(int i = 0; i < es1.size() + es2.size(); i += 1) {
      if(es1.size() == index1) {
        merged.add(es2.get(index2));
        index2 += 1;
        continue;
      }
      if(es2.size() == index2) {
        merged.add(es1.get(index1));
        index1 += 1;
        continue;
      }
      int compared = c.compare(es1.get(index1), es2.get(index2));
      if(compared > 0) {
        merged.add(es2.get(index2));
        index2 += 1;
      }
      else {
        merged.add(es1.get(index1));
        index1 += 1;
      }
    }
    return merged;
  }

  void testMerge(Tester t) {
    List<String> strs1 = Arrays.asList("a", "d", "f");
    List<String> strs2 = Arrays.asList("b", "c", "g");
    List<String> result = Arrays.asList("a", "b", "c", "d", "f", "g");
    t.checkExpect(merge(new StringCompare(), strs1, strs2), result);

    List<String> empty = Arrays.asList();
    t.checkExpect(merge(new StringCompare(), strs1, empty), strs1);
    t.checkExpect(merge(new StringCompare(), empty, strs2), strs2);

  }
}
