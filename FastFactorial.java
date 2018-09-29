import java.util.Scanner;
import java.math.BigInteger;

public class FastFactorial{
  static BigInteger mo = new BigInteger("4294967296");
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    BigInteger s;
    int n = sc.nextInt();
    long t = 0;
    for(int i = 0;i<n;++i){
      BigInteger f = sc.nextBigInteger();
      
      if(f.compareTo(new BigInteger("33")) <= 0){
        BigInteger d = new BigInteger("1");
        int a = f.intValue();
  
        for(int z=  1;z<=a;++z){
          d = d.multiply(new BigInteger(z+""));
          d = d.mod(mo);
        }
        System.out.println(d);
      }
      else System.out.println(0);
    }
  }
}