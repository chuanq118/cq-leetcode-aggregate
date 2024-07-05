class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int[] maxInCol = new int[matrix[0].length];
        for(int j = 0; j < matrix[0].length; j += 1){
            int res = -1;
            for(int i = 0; i < matrix.length; i += 1){
                res = Math.max(matrix[i][j], res);
            }
            maxInCol[j] = res;
        }
        for(int j = 0; j < matrix[0].length; j += 1){
            for(int i = 0; i < matrix.length; i += 1){
                if(matrix[i][j] == -1){
                    matrix[i][j] = maxInCol[j];
                }
            }
        }
        return matrix;
    }
}