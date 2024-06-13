package cn.lqs.contest.week_383;

public class S2 {
    public int minimumTimeToInitialState(String word, int k) {
        int times = 1;
        while (k * times < word.length()) {
            if (word.startsWith(word.substring(k * times))) {
                break;
            }
            times++;
        }
        return times;
    }
}
