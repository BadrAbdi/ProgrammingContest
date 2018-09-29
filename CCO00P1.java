//object data structure creation
import java.util.*;
public class CCO00P1{
  static Scanner sc =new Scanner(System.in);
  static MySet [] N = new MySet[100];
  static LinkedHashSet<Character> n = new LinkedHashSet<Character>();
  public static void main(String[]args){
    for(int i = 65;i<91;i++)
        N[i] = new MySet();
    Scanner sc =new Scanner(System.in);
    int X = sc.nextInt();
    String [] temp = new String[X];
    sc.nextLine();
    for(int x = 0;x<X;x++){
      temp[x] = sc.nextLine();
      String[] str = temp[x].split(" ");
      char a = str[0].charAt(0);
      char b = str[2].charAt(0);
      before(a);
      if(Character.isLowerCase(b)){
        N[a].add(b);
      }
      if(Character.isUpperCase(b)){
        before(b);
      }
    }
    for(int z = 0;z<2;z++){
    for(int j = 0;j<X;j++){
      String [] str = temp[j].split(" ");
      char a = str[0].charAt(0);
      char b = str[2].charAt(0);
      finish(a,b);
    }
    }
    TreeSet<Character> z = new TreeSet<Character>(n);
    for(int i = 0;i<n.size();i++){
      ArrayList<Character> fun = new ArrayList<Character>(z);
      TreeSet<Character> x = new TreeSet<Character>(N[fun.get(i)].getInfo());
      ArrayList<Character> nec = new ArrayList<Character>(x);
      String fa = nec.toString().replace("[","{").replace("]","}").replace(" ","");
      System.out.println(fun.get(i) + " = "+ fa);
    }
  }
  public static void finish(char f,char s){
    if(Character.isUpperCase(s))
      (N[f].getInfo()).addAll(N[s].getInfo());

  }
  public static void before(char f){
    if(!(n.contains(f)))
      n.add(f);
  }
}
class MySet{
  private LinkedHashSet<Character> myChar;
  public MySet(){
    myChar = new LinkedHashSet<Character>();
  }
  public void add(char a){myChar.add(a);}
  public LinkedHashSet<Character> getInfo(){return myChar;} 
}