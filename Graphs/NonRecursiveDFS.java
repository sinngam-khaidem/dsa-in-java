import java.util.*;

public class NonRecursiveDFS{
    public static int getAdjacentUnvisitedVertex(int v, int[][] G, int[] visited){
        int n = G.length;
        for(int i=0; i<n; i++){
            if(G[v][i] != 0 && visited[i] == 0)
                return i;
        }
        return -1;
    }

    public static void dfs(int[][] G, int start){
        int n = G.length; //number of vertices
        int[] visited = new int[n];

        ArrayDeque<Integer> st = new ArrayDeque<>();
        visited[start] = 1;
        st.push(start);
        System.out.print(start + " ");

        while(!st.isEmpty()){
            int v = getAdjacentUnvisitedVertex(st.peekFirst(), G, visited);
            if(v == -1){
                st.pop();
            }
            else{
                st.push(v);
                visited[v] = 1;
                System.out.print(v + " ");
            }
        }
        System.out.print("\n");
    }

    // Function to print all the elements of an array
    
    
    
    public static void main(String[] args){
        int[][] G = {{0,1,0,0,0,1}, 
                    {0,0,1,1,0,0},
                    {0,1,0,0,1,0},
                    {0,1,0,0,0,0},
                    {0,0,1,0,0,0},
                    {1,0,0,0,0,0}};
        dfs(G, 0);
    }
}