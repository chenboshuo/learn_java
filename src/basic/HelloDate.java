// there's a certain library of classes 
// that are automatically brought into every java file:java.lang
import java.util.*; // jvava.utl.Date

public class HelloDate {

  public static void main(String[] args) {
    System.out.println("Hello it's");
    System.out.println(new Date());
    /**
     * the argument is a Data object that is created just
     * to send its value
     * (which os automatically converted into a String)
     * to println.
     * As soon as this statement is finished,
     * the Date is unnecessary,
     * and the garbage collector can come along and get it anytime.
     * We don't worry about cleaning it up.
     */
  }
}
