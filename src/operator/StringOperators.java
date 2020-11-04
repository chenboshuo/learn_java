//: operators/StringOperators.java

public class StringOperators {
  public static void main(String[] args) {
    int x = 0, y = 1, z = 2;
    String s = "x, y, z ";
    System.out.println(s+x+y+z);
    // x, y, z 012

    s += "(summed) = "; // concatenation operator
    System.out.println(s+(x+y+z));
    // x, y, z (summed) = 3

    System.out.println(""+x); // shorthand for Integer.toString
    // 0

  }
}/* output:
x, y, z 012
x, y, z (summed) = 3
0
*///:~