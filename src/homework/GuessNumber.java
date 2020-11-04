import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
  static private void guess() {
    Scanner input = new Scanner(System.in);
    int num = (int)(Math.random() * 100);
    // int num = 5;
    int guess;
    int times = 1;
    System.out.println("Guess which number I came up with.");
    guess = input.nextInt();
    while (guess != num) {
      // System.out.println("you are wrong");
      if (guess > num) {
        System.out.println(guess + " is greater than expected");
      } else {
        System.out.println(guess + " is less than expected");
      }
      guess = input.nextInt();
      ++times;
    }
    System.out.println("You are right,you have tried " + times + " times");
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    while (true) {
      guess();
      System.out.println("You want to go again?[y/n]");
      char wantAnother;
      wantAnother = input.next().charAt(0);
      if (wantAnother != 'y' && wantAnother != 'Y') {
        break;
      }
    }
  }
}
