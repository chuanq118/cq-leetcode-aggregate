class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            if(ch == ']'){
                k = sb.length() - 1;
                while(sb.charAt(k) != '['){
                    k -= 1;
                }
                int nk = k - 1;
                while(nk >= 0 && '0' <= sb.charAt(nk) && sb.charAt(nk) <= '9'){
                    nk -= 1;
                }
                
                sb.setLength(nk + 1);
            }
            if('0' <= ch && ch <= '9'){

            }
            if('a' <= ch && ch <= 'z'){

            }
        }
    }
}