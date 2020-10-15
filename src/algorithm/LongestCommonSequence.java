/**
 * longest common sequence problem
 * 
 * @author lu Wei
 * @author Chen Boshuo
 * @version 1.0
 */

public class LongestCommonSequence {
  static final int INIT = 0;
  static final int SOUTHEAST = 1;
  static final int NORTH = 2;
  static final int SOUTH = 3;

  /**
   * find the longest common sequence using dp
   * 
   * @param longerString    string
   * @param shorterString    string
   * @param trace the matrix use to trace the sequence trace[i][j] = k; means
   *              longerString[0...i] and shorterString[0...j] generate from, for instance, trace[i][j]
   *              = NORTH means it same to the north in the matrix longerString x shorterString
   * @return length of longest common sequence
   */
  public static int longestComSeq(String longerString, String shorterString, int[][] trace) {
    char[] seq1 = longerString.toCharArray();
    char[] seq2 = shorterString.toCharArray();

    // int[][] res = new int[seq1.length + 1][seq2.length + 1];

    return longestComSeq(seq1, seq2, trace);
  }

  /**
   * find the longest common sequence using dp
   * 
   * @param longerString    string
   * @param shorterString    string
   * @param trace the matrix use to trace the sequence trace[i][j] = k; means
   *              longerString[0...i] and shorterString[0...j] generate from, for instance, trace[i][j]
   *              = NORTH means it same to the north in the matrix longerString x shorterString
   * @return length of longest common sequence
   */
  public static int longestComSeq(char[] longerString, char[] shorterString, int[][] trace) {

    trace[0][0] = 0;
    int[] memo = new int[shorterString.length + 1];

    memo[0] = 0;
    for (int i = 1; i <= longerString.length; ++i) {
      int pre = 0;
      for (int j = 1; j <= shorterString.length; ++j) {
        int temp = memo[j];
        if (longerString[i - 1] == shorterString[j - 1]) {
          memo[j] = pre + 1;
          trace[i][j] = SOUTHEAST;
        } else if (memo[j - 1] > memo[j]) {
          memo[j] = memo[j - 1];
          trace[i][j] = SOUTH;
        } else {
          trace[i][j] = NORTH;
        }
        pre = temp;
      }

    }
    return memo[shorterString.length];

  }

  /**
   * find out the sequence using trace matrix
   * 
   * @param longerString     the longer string
   * @param trace  (m+1)x(n+1) matrix, where m is the longer string length,n is the shorter string length
   * @param longerStringTail the end location of the longer string
   * @param shorterStringTail the end location of the shorter string
   */
  public static void traceBack(char[] longerString, int[][] trace, int longerStringTail, int shorterStringTail) {
    if (longerStringTail == 0 || shorterStringTail == 0)
      return;
      
    //  trace the southeast direction trace[i-1][j-1]
    if (trace[longerStringTail][shorterStringTail] == SOUTHEAST) {
      traceBack(longerString, trace, longerStringTail - 1, shorterStringTail - 1);
      System.out.print(longerString[longerStringTail - 1] + " ");
    } else if (trace[longerStringTail][shorterStringTail] == NORTH) {// trace to north direction trace[i-1][j]
      traceBack(longerString, trace, longerStringTail - 1, shorterStringTail);
    } else
      traceBack(longerString, trace, longerStringTail, shorterStringTail - 1);// trace to south direction trace[i][j-1]
  }

  public static void main(String[] args) {

    char[] longerString = { 'a', 'b', 'c', 'b', 'd', 'a', 'b' };
    char[] shorterString = { 'b', 'd', 'c', 'a', 'b', 'a' };
    // String seq1 = "abcbdab";
    // String seq2 = "bdcaba";

    // char[] longerString = {'1', '2', '3', '4', '5', '6', '7', '8'};
    // char[] shorterString = {'1', '4', '2', '3', '6', '8', '5', '7'};

    System.out.print("sequence1: ");
    for (int i = 0; i < longerString.length; i++) {
      System.out.print(longerString[i] + " ");
    }
    System.out.println();
    System.out.print("sequence2: ");
    for (int i = 0; i < shorterString.length; i++) {
      System.out.print(shorterString[i] + " ");
    }
    System.out.println();

    // int[][] resultMatrix = new int[longerString.length + 1][shorterString.length + 1];
    int[][] traceMatrix = new int[longerString.length + 1][shorterString.length + 1];

    System.out.println("The length of the longest common sequence is: " + longestComSeq(longerString, shorterString, traceMatrix));

    // System.out.println("The length of the longest common sequence is: " +
    // longestComSeq(seq1, seq2, traceMatrix));

    System.out.print("The longest common sequence is: ");
    traceBack(longerString, traceMatrix, longerString.length, shorterString.length);
  }
}
