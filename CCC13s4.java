//graph theory bfs
import java.io.*;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.StringTokenizer;
public class CCC13s4{
  //private BufferedReader sc;
  public static void main(String[]args)throws Exception{
    Input sc = new Input();
    int N = sc.nextInt();
    int M = sc.nextInt();
    Graph g = new Graph(N);
    for(int x = 0;x<M;x++){
      int a = sc.nextInt();
      int b = sc.nextInt();
      g.addEdge(a,b);
    }
    int q = sc.nextInt();
    int k = sc.nextInt();
    
    if(g.bfs(q,k))System.out.println("yes");
    else if(g.bfs(k,q)) System.out.println("no");
    else System.out.println("unknown");
   
    
  }
  static class Input{
    private BufferedReader in;
    private StringTokenizer st;
    
    Input(){
      in = new BufferedReader(new InputStreamReader(System.in));
    }
    String next() throws Exception{
      while(st == null || !st.hasMoreElements()){
        st = new StringTokenizer(in.readLine());
      }
      return st.nextToken();
      }
    Integer nextInt() throws Exception{
      return Integer.parseInt(next());
    }
    Double nextDouble() throws Exception{
      return Double.parseDouble(next());
    }
    Long nextLong() throws Exception{
      return Long.parseLong(next());
    }
    String nextLine() throws Exception{
      return in.readLine();
    }
    }
  
}
class Graph{
  private int v;
  private LinkedList<Integer> adj[];
  
  @SuppressWarnings("unchecked")
  public Graph(int v){
    this.v = v;
    adj = new LinkedList[v+1];
    for(int x =1;x<=v;x++)
      adj[x] = new LinkedList<Integer>();
  }
  
  public boolean bfs(int source,int end){
    boolean[] visited = new boolean[v+1];
    
    visited[source] = true;
    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.add(source);
    //if(source == end) return true;
    while(queue.size() !=0){
      
      source = queue.poll();
      Iterator<Integer> itr = adj[source].listIterator();
      if(source == end) return true;
      while(itr.hasNext()){
        int n = itr.next();
        if(!visited[n]){
          visited[n] = true;
          queue.add(n);
          
        }
        if(n == end) return true;
      }
    }
    return false;
  }
  
  public void addEdge(int v,int w,boolean undirected){
    adj[v].add(w);
    adj[w].add(v);
  }
  public void addEdge(int v,int w){
    adj[v].add(w);
  }
  public void removeEdge(int v,int w,boolean undirected){
    try{
    adj[v].remove(w);
    }catch (Exception e){};
    try{
      adj[w].remove(v);
    }catch (Exception e){};
  }
  public void removeEdge(int v,int w){
    try{
      adj[v].remove(w);
    }catch (Exception e){};
  }
}