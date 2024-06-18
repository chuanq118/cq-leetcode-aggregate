class Solution {
    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();
        for(String word : sentence.trim().split(" ")){
            if(word.length() > 1 && word.startsWith("$")){
                boolean flag = true;
                for(int i = 1; i < word.length(); i += 1){
                    if('0' > word.charAt(i) || word.charAt(i) > '9'){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    long price = Long.parseLong(word.substring(1));
                    double newPrice = (double)((100 - discount) * price) / 100;
                    sb.append('$').append(String.format("%.2f", newPrice)).append(' ');
                    continue;
                }
            }
            sb.append(word).append(' ');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}