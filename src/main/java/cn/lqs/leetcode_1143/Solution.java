package cn.lqs.leetcode_1143;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] dp = new int[t1.length][t2.length];
       
        boolean[] flag1 = new boolean[t1.length];
        boolean[] flag2 = new boolean[t2.length];
        if(t1[0] == t2[0]){
            flag1[0] = true;
            flag2[0] = true;
            dp[0][0] = 1;
        }else{
            dp[0][0] = 0;
        }

        for(int m = 1; m < t1.length; m++){
            if(flag2[0]){
                dp[m][0] = 1;
            }else{
                if(t1[m] == t2[0]){
                    flag2[0] = true;
                    flag1[m] = true;
                    dp[m][0] = 1;
                    continue;
                }
                dp[m][0] = 0;
            }
        }

        for(int n = 0; n < t2.length; n++){
            if(flag1[0]){
                dp[0][n] = 1;
            }else{
                if(t1[0] == t2[n]){
                    flag1[0] = true;
                    flag2[n] = true;
                    dp[0][n] = 1;
                    continue;
                }
                dp[0][n] = 0;
            }
        }

        for(int m = 1; m < t1.length; m++){
            for(int n = 1; n < t2.length; n++){
                int base = Math.max(dp[m][n - 1], dp[m -1][n]);
                boolean nonUsed = !flag1[m] && !flag2[n];
                if(t1[m] == t2[n]){
                    dp[m][n] = base + (nonUsed ? 1 : 0);
                    if(nonUsed){
                        flag1[m] = true;
                        flag2[n] = true;
                    }
                }else{
                    dp[m][n] = base;
                }
            }
        }
        formatPrint(t1, t2, dp);
        return dp[t1.length - 1][t2.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String text1 = "pmjghexybyrgzczy";
        String text2 = "hafcdqbgncrcbihkd";
        System.out.println();
        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }
    
    private void formatPrint(char[] t1, char[] t2, int[][] dp){
        for (int i = 0; i < t1.length + 1; i++) {
            for (int j = 0; j < t2.length + 1; j++) {
                if(i == 0 && j == 0){
                    System.out.print("  ");
                    continue;
                }
                if(i == 0){
                    System.out.print(t2[j - 1] + " ");
                    continue;
                }
                if(j == 0){
                    System.out.print(t1[i - 1] + " ");
                    continue;
                }
                System.out.print(dp[i - 1][j - 1] + " ");
            }
            System.out.println();
        }
    }
}