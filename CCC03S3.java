import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
public class CCC03S3{
  static Scanner sc = new Scanner(System.in);
  static int z = sc.nextInt();
  static int x = sc.nextInt();
  static int y = sc.nextInt();
  static String [][] grid = new String[x][y];
  static int c;
  public static void main(String[]args){
    sc.nextLine();
    for(int i = 0;i<x;i++){
      grid[i] = sc.nextLine().split("");
    
    }
    int count = 0;
    ArrayList<Integer> rooms = new ArrayList<Integer>();
    int total = 0;
    for(int j = 0;j<x;j++){
      for(int k =0;k<y;k++){
        if(grid[j][k].equals(".")){
          count++;
          c=0;
          findTreasure(j,k);
          rooms.add(c);
        }
      }
    }
    Collections.sort(rooms);
    int t =  rooms.size()-1;
    int rcount = 0;
    while(z-rooms.get(t) >=0){
      z -=rooms.get(t);
      rcount++;
      if(t ==0) break;
      t--;
      
    }
    
  
    System.out.println(rcount != 1 ? rcount + " rooms, " + z + " square metre(s) left over":rcount + " room, " + z + " square metre(s) left over");
  }
  public static void findTreasure(int i,int j){
    if(i >= 0 &&  i <x && j>=0 && j<y){
      if(grid[i][j].equals(".")){
        c++;
       // System.out.println(c);
        grid[i][j] = "X";
        findTreasure(i+1,j);
        findTreasure(i-1,j);
        findTreasure(i,j+1);
        findTreasure(i,j-1);
      }
    
    }

  }
}