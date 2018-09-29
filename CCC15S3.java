//simple data structure manipulation
import java.util.Scanner;
import java.util.TreeSet;
public class CCC15S3{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    TreeSet<Integer> gate = new TreeSet<Integer>();
    for(int x = 1;x<=N;x++)
      gate.add(x);
    int c = sc.nextInt();
    int count = 0;
    for(int x =0;x<c;x++){
      int d =  sc.nextInt();
      try{
        int o = gate.floor(d);
        gate.remove(o);
        count++;
      }
      catch(Exception e){
        System.out.println(count);
        System.exit(0);
      }
    }
      

    System.out.println(count);
  }
}