class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < nums.length; i += 1){
            while(!stk.isEmpty() && nums[stk.peek()] < nums[i]){
                ans[stk.pop()] = nums[i];
            }
            stk.push(i);
        }
        for(int i = 0; i < nums.length; i += 1){
            while(!stk.isEmpty() && nums[stk.peek()] < nums[i]){
                ans[stk.pop()] = nums[i];
            }
            if(stk.isEmpty()){
                break;
            }
        }
        while(!stk.isEmpty()){
            ans[stk.pop()] = -1;
        }
        return ans;
    }
}