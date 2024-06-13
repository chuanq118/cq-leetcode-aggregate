package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    List<List<String>> ans = new ArrayList<>();
    List<String> collector = new ArrayList<>();
    public List<List<String>> partition(String s) {
        doPartition(s, 0);
        return ans;
    }

    private void doPartition(String s, int si){
        if(si >= s.length()) {
            ans.add(new ArrayList<>(collector));
            return;
        }
        for(int i = si; i < s.length(); i++){
            if (isPalindrome(s, si, i)) {
                int nsi = i + 1;
                collector.add(s.substring(si, nsi));
                doPartition(s, nsi);
                collector.remove(collector.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int si, int ed) {
        while (si < ed) {
            if (s.charAt(ed) != s.charAt(si)){
                return false;
            }
            si++;
            ed--;
        }
        return true;
    }
}