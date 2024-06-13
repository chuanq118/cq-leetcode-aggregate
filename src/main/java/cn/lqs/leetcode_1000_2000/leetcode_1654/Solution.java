package cn.lqs.leetcode_1654;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private boolean[] flag = new boolean[2001];
    private int step = 0;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if(x == 0) return 0;
        int maxForbidden = Integer.MIN_VALUE;
        for(int num : forbidden){
            flag[num] = true;
            maxForbidden = Math.max(maxForbidden, num);
        }
        int maxPos = Math.max(maxForbidden + a, x) + b;
        Queue<Position> Q = new LinkedList<>();
        if(flag[a]){
            return -1;
        }
        Q.offer(new Position(a, true, 1));
        while(!Q.isEmpty()){
            Position p = Q.poll();
            if(p.pos == x){
                return p.step;
            }
            // check right jump
            int nextPos = p.pos + a;
            if((nextPos > 2000 || !flag[nextPos]) && nextPos <= maxPos){
                Q.offer(new Position(nextPos, true, p.step + 1));
            }
            // check left jump
            if(p.allowLeft){
                nextPos = p.pos - b;
                if(nextPos >= 0 && (nextPos > 2000 || !flag[nextPos]) && nextPos < maxPos){
                    Q.offer(new Position(nextPos, false, p.step + 1));
                }
            }
        }
        return -1;
    }

    static class Position{
        int pos;
        boolean allowLeft;
        int step;

        public Position(int pos, boolean allowLeft, int step){
            this.pos = pos;
            this.allowLeft = allowLeft;
            this.step = step;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Position) {
                Position p = (Position) obj;
                return this.pos == p.pos && this.allowLeft == p.allowLeft;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + pos;
            result = 31 * result + (allowLeft ? 1 : 0);
            return result;
        }
    }

    public static void main(String[] args) {
        HashSet<Position> set = new HashSet<>();
        set.add(new Position(1, true, 1));
        set.add(new Position(1, false, 2));
        set.forEach(System.out::println);
        System.out.println(set.contains(new Position(1, false, 3)));
        // System.out.println(new Position(1, true, 1)
        //         .equals(new Position(1, true, 2)));
        // Solution solution = new Solution();
        // int[] forbidden = {162,118,178,152,167,100,40,74,199,186,26,73,200,127,30,124,193,84,184,36,103,149,153,9,54,154,133,95,45,198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,111,6,168,31,134,164,136,72,98};
        // int a = 29;
        // int b = 98;
        // int x = 80;
        // int result = solution.minimumJumps(forbidden, a, b, x);
        // System.out.println(result);
    }
}