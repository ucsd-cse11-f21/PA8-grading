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

//Comparators 1
class PointCompare implements Comparator<Point> {
  public int compare(Point n, Point m) {
    if (n.y == m.y) {
        if (n.x > m.x) {return 1;}
        else if (n.x < m.x) {return -1;}
        else { return 0;}
      }
      else if (n.y < m.y) { return -1;} 
      else {return 1;}
    }

    Point p1 = new Point(1, 2);
    Point p2 = new Point(2, 3);
    Point p3 = new Point(3, 3);
    Point p4 = new Point(3, 3);

    boolean testPointCompare(Tester t) 
    {
        return t.checkExpect(this.compare(p1, p2), -1)&&
        t.checkExpect(this.compare(p3, p2), 1) &&
        t.checkExpect(this.compare(p1, p4), -1) &&
        t.checkExpect(this.compare(p3, p4), 0);
    }

}

//Comparators 2
class PointDistanceCompare implements Comparator<Point> {
  public int compare(Point n, Point m) {
    Point origin = new Point(0, 0);
    double nFrom0 = n.distance(origin);
    double mFrom0 = m.distance(origin);
    if (nFrom0 < mFrom0) { return -1;}
    else if (nFrom0 > mFrom0) { return 1;}
    else { return 0;}
  }
  
  Point p1 = new Point(1, 2);
  Point p2 = new Point(2, 3);
  Point p3 = new Point(3, 3);
  Point p4 = new Point(3, 3);

  boolean testPointCompare(Tester t) 
  {
      return t.checkExpect(this.compare(p1, p2), -1)&&
      t.checkExpect(this.compare(p3, p2), 1) &&
      t.checkExpect(this.compare(p1, p4), -1) &&
      t.checkExpect(this.compare(p3, p4), 0);
  }
}

//Comparators 3
class StringCompare implements Comparator<String> {
  public int compare(String str1, String str2) {
    return  str1.compareTo(str2);
  }
}

//Comparators 4
class StringLengthCompare implements Comparator<String> {
  public int compare(String s1, String s2) {
    return s1.length()-s2.length();
  }

    String str1 = "abc";
    String str2 = "abcd";
    String str3 = "1234";
    String str4 = "ab";

    boolean testStringLengthCompare(Tester t) 
    {
        return t.checkExpect(this.compare(str1, str2), -1)&&
        t.checkExpect(this.compare(str2, str3), 0) &&
        t.checkExpect(this.compare(str3, str4), 1);
    }
}

//Comparators 5
class BooleanCompare implements Comparator<Boolean> {
  public int compare(Boolean o1, Boolean o2) {
    if (o1 == true && o2 == false) { return 1;}
    else if (o1 == false && o2 == true) { return -1;}
    else {return 0;}
  }
}


class CompareLists {
  //List 1
    public <E> E minimum(List<E> list, Comparator<E> comparator) {
      if (list.size() == 0) {
        return null;
      }
      E smallest = list.get(0);
      for (int i=1; i < list.size(); i++) {
        if (comparator.compare(list.get(0), smallest) < 0) {
          smallest = list.get(0);
        }
      }
      return smallest;
    }
    
    Point p1 = new Point(1, 2);
    Point p2 = new Point(2, 3);
    Point p3 = new Point(3, 3);

    List<Point> l1 = Arrays.asList(p1, p2);
    List<Point> l2 = Arrays.asList(p2, p3);
    Comparator<Point> c1 = new PointCompare();
    Comparator<Point> c2 = new PointDistanceCompare();
    

    boolean testminumum(Tester t) 
    {
        return t.checkExpect(minimum(l1, c1), p1)&&
        t.checkExpect(minimum(l2, c2), p2);
        //t.checkExpect(this.compare(str3, str4), 1);
    }

  //List 2 Overload minimum
  public <E> E minimum(E[] e, Comparator<E> comparator) {
    if (e.length == 0) {
      return null;
    }
    E smallest = e[0];
    for (int i=1; i < e.length; i++) {
      if (comparator.compare(e[i], smallest) < 0) {
        e[i] = smallest;
      }
    }
    return smallest;
  }


  //List 3 greaterThan
  public  <E> List<E> greaterThan(List<E> list, Comparator<E> comparator, E e) {
    List<E> toReturn = new ArrayList<E>();
      for (E es: list) {
        if (comparator.compare(es, e) >0 ) {
          toReturn.add(es);
        }
      }
      return toReturn;
    }

  //List 4 inOrder
  public <E> boolean inOrder(List<E> list, Comparator<E> comparator) {
    if (list.size() == 0) {
      throw new IllegalArgumentException("null value in array");
      }

    for (int i = 0; i < list.size(); ++i) {
      if (comparator.compare(list.get(0), (list.get(1))) > 0)
          return false;
        }
        return true;
      }

  //List 5 overload inOrder
  public <E> boolean inOrder(E[] e, Comparator<E> comparator) {
    if (e.length == 0) {
      throw new IllegalArgumentException("null value in array");
      }
    for (int i = 0; i < e.length; ++i) {
      if (comparator.compare(e[i], e[i+1]) > 0) 
          return false;
        }
        return true;
      }

  //List 6 merge
  public <E> List<E> merge(Comparator<E> comparator, List<E> list1, List<E> list2) {
    List<E> toReturn = new ArrayList<>();
    int i1=0;
    int i2=0;
    while (i1< list1.size() && i2<list2.size()) {
      if (list1.size()==0) {
        throw new IllegalArgumentException("null value in first list");
      }
      if (list2.size()==0) {
        throw new IllegalArgumentException("null value in second list");
      }
      if(comparator.compare(list1.get(i1), list2.get(i2)) < 0){
        toReturn.add(list1.get(i1));
      }
      else {
        toReturn.add(list2.get(i2));
      }
  }
  return toReturn;
}
}



