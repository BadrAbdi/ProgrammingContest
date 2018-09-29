import java.util.Scanner;
public class CCC11S4{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    int [] unit = new int[8];
    int [] people = new int[8];
    for(int x = 0;x<8;x++)
      unit[x] = sc.nextInt();
    for(int x = 0;x<8;x++)
      people[x] = sc.nextInt();
    int count = 0;
     for(int x = 0;x<8;x++){
      if(unit[x] >= people[x]){
        count += people[x];
        unit[x] -= people[x];
        people[x] = 0;
      
      }
      else{
        count+= unit[x];
        people[x] -= unit[x];
        unit[x] = 0;
      }
    }
     for(int x = 1;x<8;x+=2){
      if(unit[x-1] >= people[x]){
        count += people[x];
        unit[x-1] -= people[x];
        people[x] = 0;
      }
      else{
        count+= unit[x-1];
        people[x] -= unit[x-1];
        unit[x-1] = 0;
      }
    
    }
   
    for(int x = 2;x<8;x+=2){
      
      if(unit[0] >0){
       
       if(people[x] >= unit[0]){
        count+=unit[0];
        people[x] -=unit[0];
        unit[0] = 0;
      }
      else if(people[x] > 0 && people[x] < unit[0]){
        count+=people[x];
        unit[0] -=people[x];
        people[x] = 0;
      }
      }
      
      else break;
    }
    for(int x = 3;x<8;x+=2){
      if(unit[1] >0){
        if(people[x] >= unit[1]){
          count+=unit[1];
          people[x] -=unit[1];
          unit[1] = 0;
        }
        else if(people[x] > 0 && people[x] < unit[1]){
          count+=people[x];
          unit[1] -= people[x];
          people[x] = 0;
        }
      }
        if(unit[0] >0){
       
       if(people[x] >= unit[0]){
        count+=unit[0];
        people[x] -=unit[0];
        unit[0] = 0;
      }
      else if(people[x] > 0 && people[x] < unit[0]){
        count+=people[x];
        unit[0] -=people[x];
        people[x] = 0;
      }
      }
      
      else break;
    }
    int neg= 0;
    for(int x = 0;x<7;x+=2)
      neg+=unit[x];
    int pos =0;
    for(int x = 1;x<7;x+=2)
      pos+=unit[x];

    if(people[6]!=0){
    if(people[6] >= neg) count+=neg;
    else count+=people[6];
    }
    if(people[7]!=0){
    if(people[7] >=pos) count+=pos;
    else count+=people[7];
    }
    System.out.println(count + " " );
      
  }
}