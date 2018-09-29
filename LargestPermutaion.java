import java.util.Scanner;
public class LargestPermutaion{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    int [] array = new int[N];
    int [] pos = new int[N+1];
    for(int x = 0;x<N;x++){
      array[x] = sc.nextInt();
      pos[array[x]] =x;
    }
    for(int i = 0;i<N && K>0;i++){
      if(array[i] == N-i)
        continue;
      array[pos[N-i]] = array[i];
      pos[array[i]] = pos[N-i];
      pos[N-i] = i;
      array[i] = N-i;
      K--;
    }
    for(int t = 0;t<N;t++)
      System.out.print(array[t] + " ");
  }
}
