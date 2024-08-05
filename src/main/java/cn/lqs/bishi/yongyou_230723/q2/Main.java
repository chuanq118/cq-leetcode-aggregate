package cn.lqs.bishi.yongyou_230723.q2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // nums = [1,3,-1,-3,5,3,6,7], k = 3
        String inpStr = in.nextLine();
        int idx = 0;
        while (inpStr.charAt(idx) != '[') {
            idx += 1;
        }
        idx += 1;
        int preIdx = idx;
        while(inpStr.charAt(idx) != ']'){
            idx += 1;
        }
        String[] pieces = inpStr.substring(preIdx, idx).trim().split(",");
        int[] nums = new int[pieces.length];
        for (int i = 0; i < pieces.length; i++) {
            nums[i] = Integer.parseInt(pieces[i].trim());
        }
        idx += 1;
        int k = Integer.parseInt(inpStr.substring(idx).split("=")[1].trim());
//        PriorityQueue<Integer> minPq = new PriorityQueue<>();
//        PriorityQueue<Integer> maxPq = new PriorityQueue<>((num1, num2) -> num2 - num1);
//        for(int i = 0; i < Math.min(k, nums.length); i++) {
//            minPq.add(nums[i]);
//            maxPq.add(nums[i]);
//        }
//        int ans = maxPq.peek() - minPq.peek();
//        for(int i = k; i < nums.length; i += 1){
//            maxPq.remove(nums[i - k]);
//            minPq.remove(nums[i - k]);
//            maxPq.add(nums[i]);
//            minPq.add(nums[i]);
//            ans = Math.max(maxPq.peek() - minPq.peek(), ans);
//        }
//        System.out.println(ans);
        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();
        for (int i = 0; i < Math.min(k, nums.length); i += 1) {
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[i]) {
                maxQ.pollLast();
            }
            maxQ.offerLast(i);
            while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[i]) {
                minQ.pollLast();
            }
            minQ.offerLast(i);
        }
        int ans = nums[maxQ.peekFirst()] - nums[minQ.peekFirst()];
//        System.out.println(ans);
        for (int i = k; i < nums.length; i += 1) {
            while (!maxQ.isEmpty() && maxQ.peekFirst() < (i - k + 1)){
                maxQ.pollFirst();
            }
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[i]) {
                maxQ.pollLast();
            }
            maxQ.offerLast(i);
            while (!minQ.isEmpty() && minQ.peekFirst() < (i - k + 1)){
                minQ.pollFirst();
            }
            while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[i]) {
                minQ.pollLast();
            }
            minQ.offerLast(i);
            ans = Math.max(nums[maxQ.peekFirst()] - nums[minQ.peekFirst()], ans);
        }
        System.out.println(ans);
    }
}
