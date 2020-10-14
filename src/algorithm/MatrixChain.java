
/**
* Matrix chain problem
*
* @author chenboshuo
* @version 0.1
* @see <a href="https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/">Matrix Chain Multiplication | DP-8</a>
*/

import java.util.*;

public final class MatrixChain {

  /**
   * Given a sequence of matrices, find the most efficient way to multiply these
   * matrices together
   * 
   * @param shapes    represents the chain of matrices such that the ith matrix Ai
   *                  is of dimension shapes[i-1] x shapes[i]
   * @param breakLocs the break locations of the matrixes, break_loc[i][j] means
   *                  the ith multiplication breaks showns p[0] x p[1] ... p[j-1]
   *                  x p[j]... (A_1 ... A_j)(...)
   * @return Minimum number of multiplications
   */
  public static int minMatrixChain(int[] shapes, int[][] breakLocs) {

    // return recurMatrixChain(shapes, breakLocs, 1, shapes.length - 1);

    return matrixChain(shapes, breakLocs);
  }

  /**
   * find the minimum number of multiplications using recursion
   * 
   * @param shapes    represents the chain of matrices such that the ith matrix Ai
   *                  is of dimension shapes[i-1] x shapes[i]
   * @param breakLocs the break locations of the matrixes, breakLocs[i][j] = space
   *                  means the matrix series (Ai x A_i+1 ... A_k)(A_k+1 ... Aj)
   * @param left      矩阵链的起始位置,i>0
   * @param right     矩阵链的结束位置,j<=n
   * @return Minimum number of multiplications
   */
  public static int recurMatrixChain(int[] shapes, int[][] breakLocs, int left, int right) {
    if (left == right) { // only one matrix
      return 0;
    }
    int minMultiplications = Integer.MAX_VALUE;
    for (int i = left; i < right; ++i) {
      int u = recurMatrixChain(shapes, breakLocs, left, i) + recurMatrixChain(shapes, breakLocs, i + 1, right)
          + shapes[left - 1] * shapes[i] * shapes[right];
      if (u < minMultiplications) {
        minMultiplications = u;
        breakLocs[left][right] = i;
      }
    }
    return minMultiplications;
  }

  /**
   * find the minimum number of multiplications using dp
   * 
   * @param shapes    represents the chain of matrices such that the ith matrix Ai
   *                  is of dimension shapes[i-1] x shapes[i]
   * @param breakLocs the break locations of the matrixes, breakLocs[i][j] = space
   *                  means the matrix series (Ai x A_i+1 ... A_k)(A_k+1 ... Aj)
   * @return Minimum number of multiplications
   */
  public static int matrixChain(int[] shapes, int[][] breakLocs) {
    int[][] memo = new int[shapes.length][shapes.length];
     
    // initialize the breakLocs matrix
    for(int i=0;i<breakLocs.length;++i){
      for(int j=0;j<breakLocs.length;++j){
        breakLocs[i][j] = -1;
      }
    }

    // if left == right times = 0
    for (int i = 0; i < shapes.length; ++i) {
      memo[i][i] = 0;
    }

    // find the solution
    for (int space = 1; space < shapes.length; ++space) {
      for (int left = 1; left + space < shapes.length; ++left) {
        int right = left + space;
        memo[left][right] = Integer.MAX_VALUE;
        for (int breaks = left; breaks < right; ++breaks) {
          int u = memo[left][breaks] + memo[breaks + 1][right] 
            + shapes[left - 1] * shapes[breaks] * shapes[right];
          if (u < memo[left][right]) {
            memo[left][right] = u;
            breakLocs[left][right] = breaks;
          }
        }
      }
    }
    return memo[1][shapes.length - 1];
  }

  public static void traceBack(int i, int j, int[][] t) {
    if (i == j)
      return;

    traceBack(i, t[i][j], t);
    traceBack(t[i][j] + 1, j, t);

    System.out.print(i + "," + t[i][j] + "and");
    System.out.print(t[i][j] + 1);
    System.out.print("," + j);
    System.out.println();
  }

  public static void main(String[] args) {

    int[] matrixChain = { 30, 35, 15, 5, 10, 20, 25 };
    int matrixLength = matrixChain.length - 1;
    int[][] traceMatrix = new int[matrixLength + 1][matrixLength + 1];

    System.out.println("Matrix: ");
    System.out.print(matrixChain[0] + "×" + matrixChain[1]);
    for (int i = 2; i <= matrixLength; i++) {
      System.out.print("," + matrixChain[i - 1] + "×" + matrixChain[i]);
    }
    System.out.println();

    // int minMultiplyNum = recurMatrixChain(matrixChain, traceMatrix, 1,
    // matrixLength);
    // int minMultiplyNum = matrixChain(matrixChain, traceMatrix);
    int minMultiplyNum = minMatrixChain(matrixChain, traceMatrix);
    System.out.println("The min multiply num: " + minMultiplyNum);

    traceBack(1, matrixLength, traceMatrix);
  }
}
