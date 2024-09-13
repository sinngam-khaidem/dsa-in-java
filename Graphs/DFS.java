import java.util.*;

public class DFS {
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, ArrayList<Integer> res){
        visited[node] = 1;
        res.add(node);

        for(Integer it: adj.get(node)){
            // find an adjacent unvisited node of node
            if(visited[it] == 0)
                dfs(it, adj, visited, res);
        }
    }

    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj){
        int n = adj.size();
        int[] visited = new int[n];
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0;
        dfs(start, adj, visited, res);
        return res;
    }

    public static void main(String[] args){
        // Creating an adjcency list representation of the graph
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);
        List<Integer> res = dfsOfGraph(adj);
        System.out.println(res);
        
    }
}
