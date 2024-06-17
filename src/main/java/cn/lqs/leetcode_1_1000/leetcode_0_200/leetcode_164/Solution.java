class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for(int i = 0; i < 10; i += 1){
            buckets.add(new ArrayList<>());
        }
        ArrayList<Integer> cacheList = new ArrayList<>(nums.length);
        int maxNum = Integer.MIN_VALUE;
        for(int num : nums){
            maxNum = Math.max(maxNum, num);
            buckets.get(num % 10).add(num);
        }
        for(int i = 0; i < 10; i += 1){
            cacheList.addAll(buckets.get(i));
        }
        int base = 10;
        int round = 0;
        while(true){
            if(maxNum < base){
                break;
            }
            for(int i = 0; i < 10; i += 1){
                buckets.get(i).clear();
            }
            for(int num : cacheList){
                if(num < base){
                    buckets.get(0).add(num);
                }else{
                    buckets.get((num / base) % 10).add(num);
                }
            }
            cacheList.clear();
            for(int i = 0; i < 10; i += 1){
                cacheList.addAll(buckets.get(i));
            }
            round += 1;
            base *= 10;
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i += 1){
            ans = Math.max(cacheList.get(i) - cacheList.get(i - 1), ans);
        }
        return ans;
    }
}