class Solution {
    public String convertToTitle(int columnNumber) {
        int base = 26;
        StringBuilder sb = new StringBuilder();
        while(columnNumber > base){
            boolean flag = columnNumber % base == 0;
            if(flag){
                sb.append('Z');
            }else{
                sb.append((char)((columnNumber % base) - 1 + 'A'));
            }
            columnNumber /= base;
            if(flag){
                columnNumber -= 1;
            }
        }
        boolean flag = columnNumber % base == 0;
        if(flag){
            sb.append('Z');
        }else{
            sb.append((char)((columnNumber % base) - 1 + 'A'));
        }
        columnNumber /= base;
        if(flag){
            columnNumber -= 1;
        }
        return sb.reverse().toString();
    }
}