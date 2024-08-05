class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int up = 0;
        int i1 = num1.length() - 1, i2 = num2.length() - 1;
        for(; i1 >= 0 && i2 >= 0; i1 -= 1, i2 -= 1){
            int sum = (num1.charAt(i1) - '0') + (num2.charAt(i2) - '0') + up;
            up = sum > 9 ? 1 : 0;
            ans.append(up == 0 ? sum : sum % 10);
        }
        while(i1 >= 0){
            int sum = (num1.charAt(i1) - '0') + up;
            up = sum > 9 ? 1 : 0;
            ans.append(up == 0 ? sum : sum % 10);
            i1 -= 1;
        }
        while(i2 >= 0){
            int sum = (num2.charAt(i2) - '0') + up;
            up = sum > 9 ? 1 : 0;
            ans.append(up == 0 ? sum : sum % 10);
            i2 -= 1;
        }
        if(up > 0){
            ans.append('1');
        }
        return ans.reverse().toString();
    }
}