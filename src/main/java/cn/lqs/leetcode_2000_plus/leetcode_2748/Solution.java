class Solution {
    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        int[] preCnt = new int[10];
        for(int num : nums){
            int ln = num % 10;
            for(int k = 1; k < 10; k += 1){
                if(gcd(ln, k) == 1){
                    ans += preCnt[k];
                }
            }
            while(num >= 10){
                num /= 10;
            }
            preCnt[num] += 1;
        }
        return ans;
    }

    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}