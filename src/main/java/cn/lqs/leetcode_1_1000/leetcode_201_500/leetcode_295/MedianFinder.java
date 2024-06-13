package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_295;

import java.util.ArrayList;

class MedianFinder {

    private final ArrayList<Integer> list;

    public MedianFinder() {
        this.list = new ArrayList<>(5 * 10000);
    }

    public void addNum(int num) {
        if (this.list.isEmpty()) {
            this.list.add(num);
            return;
        }
        int l = 0, r = this.list.size() - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (num >= this.list.get(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println("l = " + l);
        System.out.println("r = " + r);
        this.list.add(l, num);
    }

    public double findMedian() {
        if ((1 & this.list.size()) == 0) {
            int idx1 = this.list.size() / 2;
            return (double) (this.list.get(idx1) + this.list.get(idx1 - 1)) / 2;
        } else {
            return (double) this.list.get(this.list.size() / 2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */