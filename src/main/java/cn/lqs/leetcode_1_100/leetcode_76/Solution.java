class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (char tc : t.toCharArray()) {
            tMap.put(tc, tMap.getOrDefault(tc, 0) + 1);
        }
        Map<Character, Integer> sMap = new HashMap<>();
        char[] sc = s.toCharArray();
        int l = 0;
        int r = l;
        String ans = s + "#";
        while (r < sc.length) {
            sMap.put(sc[r], sMap.getOrDefault(sc[r], 0) + 1);
            boolean covered = isCovered(tMap, sMap);
            if (covered) {
                while (covered) {
                    sMap.put(sc[l], sMap.get(sc[l]) - 1);
                    l += 1;
                    covered = isCovered(tMap, sMap);
                }
                if (ans.length() > (r - l + 2)) {
                    ans = s.substring(l - 1, r + 1);
                }
            }
            r += 1;
        }
        boolean covered = isCovered(tMap, sMap);
        if (covered) {
            while (covered) {
                sMap.put(sc[l], sMap.get(sc[l]) - 1);
                covered = isCovered(tMap, sMap);
            }
            if (ans.length() > (r - l + 2)) {
                ans = s.substring(l - 1, r + 1);
            }
        }
        return ans.length() > s.length() ? "" : ans;
    }

    private boolean isCovered(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
        if (sMap.size() < tMap.size()) {
            return false;
        }
        boolean ok = true;
        for (char tc : tMap.keySet()) {
            if (sMap.getOrDefault(tc, 0) < tMap.get(tc)) {
                ok = false;
                break;
            }
        }
        return ok;
    }
}