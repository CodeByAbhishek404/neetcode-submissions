class Solution {
    int[][]dir= {{-1,0},{1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        boolean [][]isVis= new boolean [n][m];
        int maxArea=0;
        for(int i=0; i<n;i++ ){
            for(int j=0; j<m;j++){
                if(grid[i][j]==1 && !isVis[i][j]){
                    int area= dfs(grid, i,j, n,m, isVis);
                    maxArea= Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

 public int dfs(int[][]grid, int r, int c, int n, int m, boolean [][] isVis){
    int area=0;
    if(r<0 || c<0 || r>=n || c>=m) return area;
    if(grid[r][c]==0 || isVis[r][c]) return area;
    area++;
    isVis[r][c]= true;
    for(int []d: dir){
        area+= dfs(grid,r+d[0], c+d[1], n,m, isVis);
    }
    return area;


 }
}

