package cn.lqs.leetcode_1000_2000.leetcode_1702;

class Solution {
    public String maximumBinaryString(String binary) {
        char[] chars = binary.toCharArray();
        int preZeroIdx = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                if (preZeroIdx == -1) {
                    preZeroIdx = i;
                }else{
                    chars[i] = '1';
                    chars[preZeroIdx] = '1';
                    chars[preZeroIdx + 1] = '0';
                    preZeroIdx += 1;
                }
            }
        }
        return String.valueOf(chars);
    }
}