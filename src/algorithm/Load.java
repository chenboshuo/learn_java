// package algorithm;

/**
 * solve the load problem using backtrack
 */
final class Loading{
  private int itemsSize;// the number of items
  private int[] weights;
  private int[] values; // the array of items' values
  private int capacity; // the capacity of the bag
  private int[] curLoading; // the current solution
  private int[] loadPlan; // the best solution 
  private int curWeight;  // current weights;
  private int curValue;  // current value;
  private int maxValue; // the best value;
  private int remainWeight; // the remain value
  private int remainValue;

  /**
   * @param weights the array of items' weights
   */
  public Loading(int[] weights, int[] values, int capacity) {
    this.itemsSize = weights.length;
    this.weights = weights;
    this.values = values;
    this.capacity = capacity;
    this.curValue = 0;
    this.curWeight = 0;
    this.remainWeight = capacity;
    this.curLoading = new int[itemsSize];
    this.loadPlan = new int[itemsSize];
    this.remainValue = 0;
    for(int itemValue: values){
      this.remainValue += itemValue;
    }
  }

  /**
   * @param i the depth of solution trees. 
   */
  public void backTrack(int i){
    if(i == itemsSize){
      if(curValue > maxValue){
        maxValue = curValue;
        // for(int j=0;j<itemsSize;++j){
        //   bestSolution[j] = solution[j];
        // }
        loadPlan = curLoading.clone();
      }
      return;
    }
    remainValue -= values[i];
    if (remainWeight+weights[i] <= capacity){ // search left subtree(solution[i] = 1)
      curLoading[i] = 1; // load it
      curWeight += weights[i];
      curValue += values[i];
      remainValue -= weights[i];
      backTrack(i+1);
      remainValue += weights[i];
      curValue -= values[i];
      curWeight -= weights[i];
    }

    // search right subtree(solution[i] = 0)
    if(bound(i)){
      curLoading[i] = 0;
      backTrack(i+1);
    }
    remainValue += values[i];
  }

  private boolean bound(int i){
    return curValue+remainValue > maxValue;
  }


  public int getMaxValue(){
    return maxValue;

  }

  public int[] getLoadingPlan(){
    return loadPlan;
  }

}


public class Load {
  /**
   * solve the max value of loading
   * 
   * @param weights       the array of weights
   * @param values        the values of items
   * @param capacity      the capacity of the bag
   * @param loadingScheme
   * @return the max value of the problem
   */
  public static int maxLoading(int[] weights, int[] values, int capacity, int[] loadingScheme) {
    Loading ld = new Loading(weights, values, capacity);

    ld.backTrack(0);
    int[] p = ld.getLoadingPlan();

    for (int i = 0; i < weights.length; ++i) {
      loadingScheme[i] = p[i];
    }
    return ld.getMaxValue();

  }

  public static void main(String[] args) {
    int[] weights = { 5, 10, 15 };
    int[] values = { 15, 20, 25 };
    int capacity = 20;
    int[] scheme = new int[weights.length];
    System.out.print("weights: " + weights[0]);
    for (int i = 1; i < weights.length; i++) {
      System.out.print(", " + weights[i]);
    }
    System.out.println();
    System.out.print("values: " + values[0]);
    for (int i = 1; i < values.length; i++) {
      System.out.print(", " + values[i]);
    }
    System.out.println();

    System.out.println("capacity: " + capacity);

    System.out.println("maxLoad: " + maxLoading(weights, values, capacity, scheme));

    System.out.print("Loading plan: " + scheme[0]);
    for (int i = 1; i < weights.length; i++) {
      System.out.print(", " + scheme[i]);
    }
    System.out.println();
  }
}
