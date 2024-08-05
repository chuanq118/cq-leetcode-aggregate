import java.util.*;

/**
 * maxSubSum 贪心 并非 最优解
 * 可以参考题解的 DP 算法
 * https://mp.weixin.qq.com/s/mPnc06RCl9XRhta2SwLoaw
 */
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int q = 0; q < t; q += 1){
            int n = in.nextInt();
            int x = in.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i += 1){
                nums[i] = in.nextInt();
            }
            System.out.println(maxSubSum(nums, x));
        }
    }

    private static int maxSubSum(int[] nums, int x){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = Integer.MIN_VALUE;
        int curSum = nums[0];
        pq.offer(curSum);
        for(int i = 1; i < nums.length; i += 1){
            res = Math.max(res, pq.peek() < x ? curSum - pq.peek() + x : curSum);
            if(curSum < 0){
                curSum = 0;
                pq.clear();
            }
            curSum += nums[i];
            pq.offer(nums[i]);
        }
        return Math.max(res, pq.peek() < x ? curSum - pq.peek() + x : curSum);
    }
}