

class Solution {
    private int INF = 2147483647;

    class Pair {
        int row, col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        // Step 1: push all gates
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    q.offer(new Pair(i, j));
                }
            }
        }

        // Step 2: BFS
        while(!q.isEmpty()){
            Pair curr = q.poll();

            for(int[] d : dir){
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                // only visit INF cells
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == INF){
                    grid[nr][nc] = grid[curr.row][curr.col] + 1;
                    q.offer(new Pair(nr, nc));
                }
            }
        }
    }
}