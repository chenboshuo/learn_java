
public class StringMatch {

  /**
   * Match the string of given pattern
   * @param s the target string
   * @param p the given pattern
   * @return the location of the pattern fist match,
   *         if not matched ,return -1 
   * 
   */  
  public static int bruteForceStringMatch(String t, String p){
		
		char[] text = t.toCharArray();
		char[] pattern = p.toCharArray();

		return bruteForceStringMatch(text, pattern);
	}

  /**
   * Match the string of given pattern using brute force method
   * @param target the target string
   * @param pattern the given pattern
   * @return the location of the pattern fist match,
   *         if not matched ,return -1 
   * 
   */
  public static int bruteForceStringMatch(char [] target, char [] pattern){
    for(int i=0;i<(target.length- pattern.length);++i){
      int j;
      for(j=0; 
          j<pattern.length && i+j < target.length;
          ++j){
        if(target[i+j] != pattern[j]){
          break;
        }
      }
      if(j == pattern.length){
        return i;
      }
    }
    return -1;
  }
	public static void main(String[] args){
		char[] text={'N', 'O', 'B', 'O', 'D', 'Y', '_', 'N', 'O', 'T', 'I', 'C', 'E', 'D', '_', 'H', 'I', 'M'};
		char[] pattern={'N', 'O', 'T'};

    System.out.print("string =\t");
		for(int i=0; i<text.length; i++)
			System.out.print(text[i]+" ");
    System.out.println();
    
    System.out.print("pattern=\t");
		for(int i=0; i<pattern.length; i++)
			System.out.print(pattern[i]+" ");
		System.out.println();
    
    System.out.print("matched location= ");
		System.out.println(bruteForceStringMatch(text, pattern));
	}
}
