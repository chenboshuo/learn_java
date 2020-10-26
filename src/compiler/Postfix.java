// package complier;
import java.io.*;
class Parser{
  static int lookahead;
  public Parser() throws IOException{
    lookahead = System.in.read();
  }

  void expr() throws IOException{
    term();
    while(true){
      if(lookahead == '+'){
        match('+');
        term();
        System.out.write('+');
      }else if(lookahead == '-'){
        match('-');
        term();
        System.out.write('-');
      }else return;
    }
  }

  void term() throws IOException{
    /**
     * The clause "throws IOException" in the definition
     * declares that an exception called IOException can occur.
     * Such a exception occurs if there is no input to be read
     * when the function exception occurs if there is no input to be read
     * when the function match uses the routine read.
     * Any function that calls match must also declare that
     * an IOException can occur during its own execution
     */
    if(Character.isDigit((char)lookahead)){
      System.out.write((char)lookahead);
      match(lookahead);
    }else throw new Error("syntax error");
  }

  void match(int t) throws IOException{
    if(lookahead == t)
      lookahead = System.in.read();
    else throw new Error("syntax error");
  }
}
public class Postfix {
  public static void main(String[] args) throws IOException{
    Parser parse = new Parser();
    parse.expr();
    System.out.write('\n');
    // System.out.println("\n");
  }
}
