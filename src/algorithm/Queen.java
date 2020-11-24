// package algorithm;

final class Placing{
  private int queenNum; // the number of queen
  private int sum; // the scheme number of Queen placing
  private int[] location; // location[x] = y


  public Placing(int queenNum){
    this.queenNum = queenNum;
    sum = 0;
    location = new int[queenNum];
  }
  public int getPlacingNum(){
    return sum;
  }

  public void backTrack(int depth){
    if(depth == queenNum){ // a correct sum
      ++sum;
      output();
    }else {
      for(int i = 0; i < queenNum;++i){
        location[depth] = i;
        if(check(depth)){
          backTrack(depth+1);
        }
      }
    }
  }

  private void output(){
    for(int i=0;i<queenNum;++i){
      System.out.print(location[i] + " ");
    }
    System.out.println();
  }

  private boolean check(int i){
    for(int j=0;j<i;++j){ // check the conflict before line depth
      // line: i, col :location[i]
      if(location[i] == location[j] || // the same col
          Math.abs(i-j) == Math.abs(location[i] - location[j])){ 
        return false;
      }
    }
    return true;
  }
}


public class Queen {
  public static int nQueen(int queenNum){
    Placing p = new Placing(queenNum);
    p.backTrack(0);
    return p.getPlacingNum();
  }    
  public static void main(String[] args){

  final int n = 4;

  int num = nQueen(n);

  System.out.println("The number of placing: " + num);
}


}
