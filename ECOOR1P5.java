import java.util.Scanner;
public class ECOOR1P2{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    
    int c =10;while(c-->0){
      int x = sc.nextInt();
      sc.nextLine();
      String [] str = sc.nextLine().split(" ");
      int y = 0;

      while(true){
        if(y>str.length-1)break;
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        for(int i = y;i<str.length;i++){
          if(str[i].length() <= x && cur+str[i].length() <=x){
            sb.append(str[i] + " ");
            y++;
            cur+=str[i].length()+1;
          }
          else if(str[i].length() > x){
            if(sb.toString().length() !=0)break;
            for(int j = 0;j<x;j++)
              sb.append(str[i].charAt(j) +"");
           str[i] = str[i].replaceFirst(sb.toString(),"");
           break;
          }
          else if(str[i].equals("")) y++;
          else break;
        }
        System.out.println(sb.toString());  
      }
      System.out.println("=====");
    }

    
  }
}