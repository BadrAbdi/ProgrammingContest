//data structure manipulation
import java.util.*;
import java.util.Map.Entry;
public class CCO99{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for(int x = 0;x<n;x++){
      int m = sc.nextInt(),k=sc.nextInt();
      HashMap<String,Integer> order = new HashMap<String,Integer>();
      for(int j = 0;j<m;j++){
        String str = sc.next();
        if(order.containsKey(str)) order.put(str,order.get(str)+1);
        else order.put(str,0);
      }
      System.out.println(end(k) + " most common word(s):");
      for(Entry<String,Integer> f : order.entrySet()){
        int count = 0;
        for(Entry<String,Integer> g : order.entrySet()){
          if(f.getValue() < g.getValue())
            count++;
        }
        if(count == k-1)
          System.out.println(f.getKey());
      }
      System.out.println();
    }
  }
  public static String end(int num){
    if(num%100 == 11 || num%100 == 12|| num%100 == 13) return num +"th";
    if(num%10 == 1) return num +"st";
    if(num%10 == 2) return num +"nd";
    if(num%10 == 3) return num +"rd";
    return num +"th";
  }
}