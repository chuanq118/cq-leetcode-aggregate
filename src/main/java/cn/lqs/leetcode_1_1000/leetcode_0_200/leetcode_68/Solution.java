package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_68;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int wc = 0;
        for (String word : words) {
            if (line.length() == 0) {
                line.append(word);
                wc++;
                continue;
            }
            int nextLen = line.length() + word.length() + 1;
            if (nextLen <= maxWidth) {
                line.append(' ').append(word);
                wc++;
                continue;
            }
            ans.add(formatLine(line, maxWidth, wc).toString());
            line.setLength(0);
            line.append(word);
            wc = 1;
        }
        while (line.length() < maxWidth) {
            line.append(' ');
        }
        ans.add(line.toString());
        return ans;
    }

    private StringBuilder formatLine(StringBuilder line, int maxWidth, int wc) {
        if (line.length() == maxWidth) {
            return line;
        }
        if (wc == 1) {
            while (line.length() < maxWidth) {
                line.append(' ');
            }
            return line;
        }
        StringBuilder newLine = new StringBuilder();
        int padding = maxWidth - line.length();
        int n1 = padding / (wc - 1);
        int n2 = padding % (wc - 1);
        int ci = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                int n = 1 + n1 + (ci < n2 ? 1 : 0);
                for (int j = 0; j < n; j++) {
                    newLine.append(' ');
                }
                ci++;
                continue;
            }
            newLine.append(line.charAt(i));
        }
        return newLine;
    }

    public static void main(String[] args) {
        new Solution().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
    }
}