package cn.lqs.leetcode_1000_2000.leetcode_1954;

class Solution {

    public long minimumPerimeter(long neededApples) {
        long lEdge = 1, rEdge = 20000;
        while (lEdge <= rEdge){
            long mEdge = (lEdge + rEdge) >> 1;
            long curApples = totalApples(mEdge);
            if (curApples > neededApples){
                rEdge = mEdge - 1;
            }else if (curApples < neededApples){
                lEdge = mEdge + 1;
            }else {
                lEdge = mEdge;
                break;
            }
        }
        return lEdge * 8;
    }

    private long totalApples(long edge) {
        long s1 = edge * (1 + edge) * 2;
        long s2 = 0L;
        for (int i = 1; i <= edge; i++) {
            for (int j = 1; j <= edge; j++) {
                s2 += (i + j);
            }
        }
        return s1 + s2;
    }

    public static void main(String[] args) {
        // 1000000000
        // 251238960
        // 125007500100000
        // 1000300020000
        // 100000000000000
        System.out.println(new Solution().totalApples(10000));
    }

}