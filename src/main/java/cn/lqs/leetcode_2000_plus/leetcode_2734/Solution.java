class Solution {
    public String smallestString(String s) {
        int si = 0;
        char[] cs = s.toCharArray();
        while(si < cs.length && cs[si] == 'a'){
            si += 1;
        }
        if(si == cs.length){
            return s.substring(0, s.length() - 1) + "z";
        }
        int ei = si;
        while(ei < cs.length && cs[ei] != 'a'){
            ei += 1;
        }
        int k = 0;
        StringBuilder sb = new StringBuilder();
        while(k < si){
            sb.append(cs[k]);
            k += 1;
        }
        while(k >= si && k < ei){
            sb.append((char) (cs[k] - 1));
            k += 1;
        }
        while(k < cs.length){
            sb.append(cs[k]);
            k += 1;
        }
        return sb.toString();
    }
}