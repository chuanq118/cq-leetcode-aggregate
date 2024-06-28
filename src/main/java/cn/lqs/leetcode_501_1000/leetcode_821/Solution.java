class Solution {
    public int[] shortestToChar(String s, char c) {
        int preChIdx = -1;
        int curChIdx = 0;
        while(curChIdx < s.length() && s.charAt(curChIdx) != c){
            curChIdx += 1;
        }
        int[] ans = new int[s.length()];
        int idx = 0;
        while(idx < s.length()){
            while(idx < curChIdx){
                if(preChIdx == -1){
                    ans[idx] = curChIdx - idx;
                }else if(curChIdx == s.length()){
                    ans[idx] = idx - preChIdx;
                }else{
                    ans[idx] = Math.min(idx - preChIdx, curChIdx - idx);
                }
                idx += 1;
            }
            if(curChIdx < s.length()){
                ans[idx] = 0;
                preChIdx = curChIdx;
                curChIdx += 1;
                while(curChIdx < s.length() && s.charAt(curChIdx) != c){
                    curChIdx += 1;
                }
            }
            idx += 1;
        }
        return ans;
    }
}