public class Literals {
  public static void main(String[] args) {
    // Hexadecimal(lowercase)
    int i1 = 0x2f;
    System.out.println("i1:\t" + Integer.toBinaryString(i1));
    // i1: 101111

    // Hexadecimal (uppercase)
    int i2 = 0X2F;
    System.out.println("i2:\t" + Integer.toBinaryString(i2));
    // i2: 101111

    // Octal (leading zero)
    int i3 = 0177;
    System.out.println("i3:\t" + Integer.toBinaryString(i3));
    // i3: 1111111

    // max char hex value
    char c = 0xffff;
    System.out.println("c:\t" + Integer.toBinaryString(c));
    // c: 1111111111111111

    // max byte hex value( Its range is -128 to 127 )
    byte b = 0x7f;
    System.out.println("b:\t" + Integer.toBinaryString(b));
    // b: 1111111

    // max short hex value
    short s = 0x7fff;
    System.out.println("s:\t" + Integer.toBinaryString(s));

    long n1 = 200L; // long suffix
    long n2 = 200l; // long suffix(but can be confusing)
    long n3 = 200;

    // float
    float f1 = 1;
    // float suffix
    float f2 = 1F; 
    float f3 = 1f;

    // double suffix
    double d1 = 1d;
    double d2 = 1D;



  }
}/* output:
i1:     101111
i2:     101111
i3:     1111111
c:      1111111111111111
b:      1111111
s:      111111111111111
*///:~