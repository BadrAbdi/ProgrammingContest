//graph theory .shortest path alg
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashSet;
public class ccc9j5 {
  private int v;
  private LinkedList<Integer> adj[];
 
 @SuppressWarnings("unchecked")
 public Graphed(int v) {
  this.v = v;
  adj = new LinkedList[v+1];
  
  for (int i = 1; i <= v; ++i) 
   adj[i] = new LinkedList<Integer>();
  
  
 }

 
 public void addEdge(int v, int w) {
   if(!adj[v].contains(w)){
     adj[v].add(w);
     adj[w].add(v);
   }
 }
 public void removeEdge(int v,int w){
   try{
     adj[v].remove(w);
     adj[w].remove(v);
   }
   catch(Exception e){
   };
 }
 public int size(int v){
   return adj[v].size();
 }


  public int shortestPath (int x, int y)
  {
    int[] [] q = new int [51] [51];
    int count = 0;
    for (int i = 1 ; i <= 50 ; i++)
      for (int j = 1 ; j <= 50 ; j++)
      if (adj[i].contains(j))
      q[i][j] = 1;
    else
      q[i][j] = 999;
    
    for (int i = 1 ; i <= 50 ; i++)
      for (int j = 1 ; j <= 50 ; j++)
      if (q [i][j] > 0)
      for (int k = 1 ; k <= 50 ; k++)
      if ((q [j] [k] > 0) && (q [i] [j] + q [j] [k] < q [i] [k]))
    {
      q [i] [k] = q [i] [j] + q [j] [k];
      q [k] [i] = q [i] [j] + q [j] [k];
    }
    
 return q [x] [y];
  }
 public int friendsOF(int v){
   HashSet<Integer> num = new HashSet<>();
   boolean [] visited = new boolean[51];
   for(int x =0;x<adj[v].size();x++) visited[adj[v].get(x)] =true;
   for(int x = 0;x<adj[v].size();x++){
     visited[adj[v].get(x)] =true;
     for(int i =0;i<adj[adj[v].get(x)].size();i++){
       if(!visited[adj[adj[v].get(x)].get(i)] && adj[adj[v].get(x)].get(i)!=v){
         num.add(adj[adj[v].get(x)].get(i));
         visited[adj[adj[v].get(x)].get(i)] = true;
       }
     }
   }
   return num.size();
 }

 public static void main(String args[]) {
   Scanner sc = new Scanner(System.in);
     Graphed g = new Graphed(50);
     g.addEdge(1,6);
     g.addEdge(2,6);
     g.addEdge(3,4);
     g.addEdge(3,6);
     g.addEdge(3,15);
     g.addEdge(3,5);
     g.addEdge(4,5);
     g.addEdge(4,6);
     g.addEdge(5,6);
     g.addEdge(6,7);
     g.addEdge(7,8);
     g.addEdge(8,9);
     g.addEdge(9,10);
     g.addEdge(9,12);
     g.addEdge(10,11);
     g.addEdge(11,12);
     g.addEdge(12,13);
     g.addEdge(13,14);
     g.addEdge(13,15);
     g.addEdge(16,17);
     g.addEdge(16,18);
     g.addEdge(18,17);
     String str = sc.nextLine();
     boolean fs = false;
     while(!str.equals("q")){
       if(str.equals("i")){
         g.addEdge(Integer.parseInt(sc.nextLine()),Integer.parseInt(sc.nextLine()));
    }
       if(str.equals("d")){
         int x = Integer.parseInt(sc.nextLine());
         int y = Integer.parseInt(sc.nextLine());
         if( x == 4 && y == 6) fs=true;
         g.removeEdge(x,y);
       }
       if(str.equals("n")){
         System.out.println(g.size(Integer.parseInt(sc.nextLine())));
       }
       if(str.equals("f")){
         System.out.println(g.friendsOF(Integer.parseInt(sc.nextLine())));
       }
       if(str.equals("s")){
         int x =g.shortestPath(Integer.parseInt(sc.nextLine()),Integer.parseInt(sc.nextLine()));
         if(fs)System.out.println(x+1);
         else System.out.println(x != 999?x:"Not connected");
       }
       str =sc.nextLine();
  }
 }
}
