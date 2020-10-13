
public class ShowProperties {
  public static void main(String[] args) {
    System.getProperties().list(System.out);
    /**
     * the first line displays all of the "properties"
     * from the system where you running the program,
     * so it gives you environment information.
     */
    System.out.println(System.getProperty("user.name"));
    /**
     * the list() method sends the results to its argument,
     * System.out
     */
    System.out.println(
      System.getProperty("java.library.path")
    );
  }
}
