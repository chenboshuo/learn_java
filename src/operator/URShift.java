//: operators/URShift.java
// Test of unsigned right shift

public class URShift{
  public static void main(String[] args) {
    int i = -1;
    System.out.println(Integer.toBinaryString(i));
    // 11111111111111111111111111111111

    i >>>=10;
    System.out.println(Integer.toBinaryString(i));
    // 1111111111111111111111

    long l=-1;
    System.out.println(Long.toBinaryString(l));
    // 1111111111111111111111111111111111111111111111111111111111111111

    l>>>=10;
    System.out.println(Long.toBinaryString(l));
    // 111111111111111111111111111111111111111111111111111111

    short s = -1;
    System.out.println(Integer.toBinaryString(s));
    // 11111111111111111111111111111111

    s >>>= 10;
    System.out.println(Integer.toBinaryString(s));
    // 11111111111111111111111111111111

    byte b = -1;
    System.out.println(Integer.toBinaryString(b));
    // 11111111111111111111111111111111

    b >>>=10;
    System.out.println(Integer.toBinaryString(b));
    // 11111111111111111111111111111111

    b = -1;
    System.out.println(Integer.toBinaryString(b));
    System.out.println(Integer.toBinaryString(b>>>10));
    // 11111111111111111111111111111111
    // 1111111111111111111111



  }
}/* output:
11111111111111111111111111111111
1111111111111111111111
1111111111111111111111111111111111111111111111111111111111111111
111111111111111111111111111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
*///:~
