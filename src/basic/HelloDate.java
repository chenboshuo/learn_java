// there's a certain library of classes 
// that are automatically brought into every java file:java.lang
import java.util.*; // jvava.utl.Date
/** The first Thinking in Java example program.
 * Displays a string and today's date.
 * @author Bruce Eckel
 * @author www.MindView.net
 * @version 4.0
 * 
 */
public class HelloDate {
  /** Entry point to class & application
   * @param args array of string arguments
   * @throws exceptions No exceptions thrown 
   */
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
/* Output (55% match)
Hello it's
Wed Oct 14 06:37:12 CST 2020
*/