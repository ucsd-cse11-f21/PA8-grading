## Comparators and List

The
[Comparator](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Comparator.html)
interface in Java describes operations that compare two values of the same
type. A `Comparator`'s `compare` method should return a negative number if
the first argument is less than the second, 0 if they are equal, and a
positive number if the first argument is greater than the second.

For example, a `Comparator` that compares two `Double`s we could write as:

```
class CompareDoubles implements Comparator<Double> {
  public int compare(Double n, Double m) {
    if(n > m) { return 1; }
    else if(m > n) { return -1; }
    else { return 0; }
  }
}
```

All of your code will go into a single file `CompareLists.java`

### Comparators

First, write the following implementations of the `Comparator` interface. You
can write them all in the file `CompareLists.java`.

1. Write a class `PointCompare` that implements `Comparator<Point>`
that compares points by the following process
    - If the first point's `y` coordinate is smaller than the other point's
    `y` coordinate, it is smaller; if `y` is greater, it's greater.
    - If the `y` coordinates are the same, if the first point's `x`
    coordinate is smaller, it is smaller, if greater, the first point is
    greater.
    - If the points have the same coordinates, return `0`
2. Write a class `PointDistanceCompare` that implements `Comparator<Point>`
for `Point`s that compares the points' distance from `(0, 0)`. If the first
point's distance is closer to 0, it's smaller, if the distances are equal,
the points are equal, and if the distance is further from 0, the point is
larger.
3. Write a class `StringCompare` that implements `Comparator<String>` that uses the
`compareTo` method on strings for comparison and returns the result of
`compareTo` directly.
4. Write a class `StringLengthCompare` that implements `Comparator<String>` that compares `String`s
by length, where shorter strings are “smaller”.
4. Write a class `BooleanCompare` that implements `Comparator<Boolean>` where
`true` is greater than `false`.

Write at least four `checkExpect` tests for each `Comparator`'s `compare`
method to demonstrate that they work correctly (so at least 20 tests total).

### List Methods

In this part of the assignment, you'll write several generic `List`
methods that make use of the `Comparator` interface. Write these all in a
class named `CompareLists` in `CompareLists.java`.

1. Write a generic method `minimum` that takes an `List<E>` and a
`Comparator<E>` and returns the _smallest_ element in the list according the
comparator, or `null` if the list is empty. Assume there are no `null`
elements in the list.
1. Write an overload of the generic method `minimum` that takes an `E[]` (an
array of `E`) and a `Comparator<E>` and returns the _smallest_ element in the
array according the comparator, or `null` if the array is empty. Assume there
are no `null` elements in the array.
2. Write a generic method `greaterThan` that takes an `List<E>`, a
`Comparator<E>`, and an element `E`, and returns a _new_ `List<E>`
containing just the elements that are _larger_ than the given element
according to the given comparator.
4. Write a generic method `inOrder` that takes an `List<E>` and a
`Comparator<E>` and returns `true` if the elements in the array list are in
increasing order according to the comparator, and `false` otherwise.
4. Write an overload of the generic method `inOrder` that takes an `E[]` (an
array of `E`) and a `Comparator<E>` and returns `true` if the elements in the
array list are in increasing order according to the comparator, and `false`
otherwise.
3. Write a generic method `merge` that takes a `Comparator<E>` and two
`List<E>`, each of which is in _increasing order_ according to the given
comparator. It should return a _new_ `List<E>` containing all the
elements from both lists in increasing order.

For each of these three methods, write a `checkExpect` test that uses the
method for _each_ of the comparators you wrote in the first part (so you
should write 30 total tests for this task).

### Tips and Tricks

<div class='sidenote'>This is similar to our uses of interfaces vs.
particular implementations!</div>

1. All of the methods are specified to use the type `List`. `List` is an
interface in Java that specifies a number of methods implemented by different
classes, though the most commonly used is `ArrayList`. So you can use `new
ArrayList` when you need to construct a new list in the body of a method, but
use the `List` type for the parameters and return types.

2. Constructing `List`s by using `new ArrayList` and then repeated calls to the
`add` method can be annoying. Instead, you can use this pattern to create lists in one line:

    ```
    List<String> abc = Arrays.asList("a", "b", "c");
    ```

    This can make writing test data much more pleasant.

3. Leave time to think through `merge`, which takes some careful thought, and
test it thoroughly to make sure you've tried it with lists of different
lengths and contents.

