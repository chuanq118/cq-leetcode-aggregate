class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        while(x >= 10){
            sum += (x % 10);
            x /= 10;
        }
        sum += x;
        return x % sum == 0 ? sum : -1;
    }
}