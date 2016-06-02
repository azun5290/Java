import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CharToInt{
  public static void main(String[] args) {
  try{
  BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
  System.out.println("Enter a char:");
  String str = buffer.readLine();
  Character c = new Character(str.charAt(0));
  System.out.println("Char: "+ c);
  String s = c.toString();
  int i = Integer.parseInt(s);
  System.out.println("Integer: "+ i);
  }
  catch (Exception e){
  System.out.println("Not a numeric!");
  e.getMessage();
  }
  }
} 