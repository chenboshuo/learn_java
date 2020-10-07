/**
 * This class use for finding the given
 * elements in a sorted array,
 * and algorithms for search the maximum 
 * @author chenboshuo
 * @see <a href="https://www.geeksforgeeks.org/binary-search>Binary Search</a>
 */
public class Search {
  /**
   * find the max element int the array
   * @param nums the array
   * @return the value of the max elements
   */
  public static int max(int[] nums){
    return linearSearchMax(nums);
  }
  /**
   * find the given element in the array nums
   * @param nums the array
   * @param target the given element
   * @return the index of the first element in the array.
   */
  public static int search(int[] nums, int target){
    return linearSearch(nums, target);
  }
  private static int linearSearchMax(int[] nums){
    int maxVal = nums[0];
    for(int i=1;i<nums.length;++i){
      maxVal = Math.max(maxVal, nums[i]);
    }
    return maxVal;
  }
  private static int linearSearch(int[] nums,int target){
    for(int i=0;i<nums.length;++i){
      if(nums[i] == target){
        return i;
      }
    }
    return -1;
  }

	public static void main(String[] args){

		int[] a = {3,5,0,8,8,-1,15};
		int x = 8;

		System.out.print("Array: ");
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		System.out.println("Search for: " + x);		
		System.out.println("Result index: " + search(a,x));

		System.out.println("The max value in a: " + max(a));
	}
}
