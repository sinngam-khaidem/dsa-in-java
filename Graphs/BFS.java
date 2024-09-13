import java.util.*;

public class BFS {
    public static int getAdjacentUnvisitedVertex(int v, int[][] G, int[] visited){
        int n = G.length;
        for(int i=0; i<n; i++){
            if(G[v][i] != 0 && visited[i] == 0)
                return i;
        }
        return -1;
    }

    public static void bfs(int[][] G, int start){
        int n = G.length; //number of vertices
        int[] visited = new int[n];

        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[start] = 1;
        q.add(start);
        System.out.print(start + " ");

        while(!q.isEmpty()){
            int v = getAdjacentUnvisitedVertex(q.peekFirst(), G, visited);
            if(v == -1){
                q.remove();
            }
            else{
                q.add(v);
                visited[v] = 1;
                System.out.print(v + " ");
            }
        }
        System.out.print("\n");
    }
    
    public static void main(String[] args){
        int[][] G = {{0,1,0,0,0,1}, 
                    {0,0,1,1,0,0},
                    {0,1,0,0,1,0},
                    {0,1,0,0,0,0},
                    {0,0,1,0,0,0},
                    {1,0,0,0,0,0}};
        bfs(G, 0);
    } 
}
