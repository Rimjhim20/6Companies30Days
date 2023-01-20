class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1) {
                   maxArea = Math.max(maxArea, traverse(grid, i, j));
                }
            }
        }
        return maxArea;
        
    }
    public int traverse(int[][] grid, int row, int col) {
         if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) {
            return 0;
        }
        int area = 1;
        grid[row][col] = 0;
        area += traverse(grid, row, col + 1);
        area += traverse(grid, row, col -1);
        area += traverse(grid, row + 1, col);
        area += traverse(grid, row - 1, col);
        return area;
    }
}