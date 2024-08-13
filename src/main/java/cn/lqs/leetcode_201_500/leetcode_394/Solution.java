class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            if(ch == ']'){
                int k = sb.length() - 1;
                while(sb.charAt(k) != '['){
                    k -= 1;
                }
                int nk = k - 1;
                while(nk >= 0 && '0' <= sb.charAt(nk) && sb.charAt(nk) <= '9'){
                    nk -= 1;
                }
                String rStr = sb.substring(k + 1);
                int times = Integer.parseInt(sb.substring(nk + 1, k));
                sb.setLength(nk + 1);
                for (int i = 0; i < times; i += 1) {
                    sb.append(rStr);
                }
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}