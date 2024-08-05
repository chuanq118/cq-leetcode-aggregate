class Solution {
    public String reverseMessage(String message) {
        if(message == null){
            return "";
        }
        message = message.trim();
        if(message.length() == 0){
            return "";
        }
        int idx = message.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(idx > -1){
            int nIdx = idx;
            while(nIdx > -1 && message.charAt(nIdx) != ' '){
                nIdx -= 1;
            }
            sb.append(message.substring(nIdx + 1, idx + 1)).append(' ');
            idx = nIdx;
            while(idx > -1 && message.charAt(idx) == ' '){
                idx -= 1;
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}