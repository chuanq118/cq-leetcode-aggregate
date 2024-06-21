class Solution {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length - 1;
        int ans = 0;
        int cnt = 0;
        for(int i = 0; i < n; i += 1){
            int statusA = temperatureA[i + 1] - temperatureA[i];
            int statusB = temperatureB[i + 1] - temperatureB[i];
            if((statusA > 0 && statusB > 0) || (statusA < 0 && statusB < 0) || (statusA == 0 && statusB == 0)){
                cnt += 1;
                ans = Math.max(ans, cnt);
            }else{
                cnt = 0;
            }
        }
        return ans;
    }
}