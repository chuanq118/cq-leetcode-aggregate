class Solution {

    String[] baseWords = new String[]{
        "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
        "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return baseWords[0];
        }
        Deque<String> dq = new LinkedList<>();
        dfs(dq, num, "", 1);
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            String word = dq.pollFirst();
            if (word.length() > 0) {
                sb.append(word).append(' ');
            }
        }
        String ans = sb.deleteCharAt(sb.length() - 1).toString();
        ans = ans.replaceAll("Million Thousand", "Million");
        ans = ans.replaceAll("Billion Thousand", "Billion");
        ans = ans.replaceAll("Billion Million", "Billion");
        return ans;
    }

    private void dfs(Deque<String> words, int num, String unit, int base) {
        if (num == 0) {
            return;
        }
        if ("".equals(unit) || "Thousand".equals(unit) || "Million".equals(unit) || "Billion".equals(unit)) {
            int val = num % 100;
            words.offerFirst(unit);
            if (val > 0 && val < 20) {
                words.offerFirst(baseWords[val]);
            } else if (val >= 20) {
                int left = val % 10;
                val = (val / 10) * 10;
                if (left > 0) {
                    words.offerFirst(baseWords[left]);
                }
                words.offerFirst(baseWords[20 + ((val - 20) / 10)]);
            }
            num /= 100;
            if (num > 0) {
                dfs(words, num, "Hundred", base * 100);
            }
        } else if ("Hundred".equals(unit)) {
            int val = num % 10;
            if (val > 0) {
                words.offerFirst(unit);
                words.offerFirst(baseWords[val]);
            }
            num /= 10;
            if (num > 0) {
                String nextUnit = "Thousand";
                if (base == 100000) {
                    nextUnit = "Million";
                }
                if (base == 100000000) {
                    nextUnit = "Billion";
                }
                dfs(words, num, nextUnit, base * 10);
            }
        }
        
    }

}