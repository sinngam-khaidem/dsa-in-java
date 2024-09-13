public class Solution {
    // https://neetcode.io/problems/count-number-of-islands
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int r, int c, char[][] grid){
        if(
            r<0 || c<0 ||
            r>=grid.length || c>= grid[0].length ||
            grid[r][c] == '0'
        ){
            return;
        }
        else{
            grid[r][c] = '0';
            dfs(r+1, c, grid); 
            dfs(r-1, c, grid);
            dfs(r, c+1, grid);
            dfs(r, c-1, grid);
        }
    }

    // https://neetcode.io/problems/max-area-of-island
    public int maxAreaOfIsland(int[][] grid) {
        int[] maxArea = new int[1];
        int[] curArea = new int[1];

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    curArea[0] = 0;
                    dfs(i, j, grid, curArea);
                    if(curArea[0] > maxArea[0])
                        maxArea[0] = curArea[0];
                }
            }
        }
        return maxArea[0];
    }
 
    public static void dfs(int r, int c, int[][] grid, int[] curArea){
        if(
            r<0 || c<0 ||
            r>=grid.length || c>= grid[0].length ||
            grid[r][c] == 0
        ){
            return;
        }
        else{
            grid[r][c] = 0;
            curArea[0]++;
            dfs(r+1, c, grid, curArea); 
            dfs(r-1, c, grid, curArea);
            dfs(r, c+1, grid, curArea);
            dfs(r, c-1, grid, curArea);
        }
    }

    public static void main(String[] args){
        int[][] grid = {{0,1,1,0}, {0,0,0,0}, {0,1,0,0}};
        
    }
}

