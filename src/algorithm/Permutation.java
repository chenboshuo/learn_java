/**
 * Permutation algorithm
 * 
 * using recursion to print the 
 * permutation of a array
 * 
 * @author chen boshuo
 * @version 0.1
 * 
 */

public class Permutation {
  /**
   * print the permutations of the array nums
   * @param nums the array to be arranged
   * @param left the locations of the begin elements
   * @param right the locations of the end elements
   */
  public static void permutation(int[] nums, int left, int right){
    if(left == right){ 
      for(int i=0; i<= right;++i){
        System.out.print(nums[i]);
        System.out.print("\t");
      }
      System.out.println();
    }
    for(int i=left;i<=right;++i){
      swap(nums,i,left);
      permutation(nums, left+1,right);
      swap(nums,i,left);
    }

  }
  private static void swap(int []a, int i, int j){
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
  public static void main(String[] args){
		int[] list=new int[5];
		for(int i=0;i<5;i++)
			list[i]=i;
		permutation(list, 0, 4);
	}

}
