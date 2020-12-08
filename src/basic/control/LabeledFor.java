// :control/LabeledFor
// For loops with labeled break and labeled continue
public class LabeledFor {
  public static void main(String[] args) {
    int i = 0;
    outer: // can't have statement here
    for (; true;) {
      inner: // can't have statement here
      for (; i < 10; ++i) {
        System.out.println("i=" + i);
        if (i == 2) {
          System.out.println("continue");
          continue;
        }
        if (i == 3) {
          System.out.println("break");
          ++i; // otherwise i never gets increment
          break;
        }
        if (i == 7) {
          System.out.println("continue outer");
          ++i; // Otherwise i never gets increment
          continue outer;
        }
        if (i == 8) {
          System.out.println("break outer");
          break outer;
        }
        for (int k = 0; k < 5; ++k) {
          if (k == 3) {
            System.out.println("continue inner");
            continue inner;
          }
        }
      }
    }
  }
}/* output:
i=0
continue inner
i=1
continue inner
i=2
continue
i=3
break
i=4
continue inner
i=5
continue inner
i=6
continue inner
i=7
continue outer
i=8
break out
*///:~
/**
 * note that break breaks out of the for loop,
 * and that increment expression doesn't
 * until the end of the pass through the for loop.
 */