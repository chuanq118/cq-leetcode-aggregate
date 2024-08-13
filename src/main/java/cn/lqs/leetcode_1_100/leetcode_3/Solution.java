class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int ans = 1;
        int l = 0;
        Map<Character, Integer> mp = new HashMap<>();
        while (l < s.length()) {
            int r = l;
            while (r < s.length() && !mp.containsKey(s.charAt(r))) {
                mp.put(s.charAt(r), r);
                r += 1;
            }
            ans = Math.max(r - l, ans);
            l = r < s.length() ? mp.get(s.charAt(r)) + 1 : r;
            mp.clear();
        }
        return ans;
    }
}