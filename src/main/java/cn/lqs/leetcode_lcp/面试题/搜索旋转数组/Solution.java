class Solution {
    public int search(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            while (l < r && arr[l] == arr[r]) {
                r -= 1;
            }
            int m = ((r - l) >> 1) + l;
            if (arr[m] == target) {
                while (m > 0 && arr[m - 1] == target) {
                    m -= 1;
                }
                return m;
            }
            if (arr[m] < target) {
                if (arr[l] > arr[r] && arr[m] <= arr[r] && target >= arr[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (arr[l] > arr[r] && arr[l] <= arr[m] && arr[r] >= target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}