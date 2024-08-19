class Solution {
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        if (plants.length == 0 || plants[0].length == 0) {
            return false;
        }
        int l = 0;
        int r = plants[0].length - 1;
        while (l <= r) {
            int m = ((r - l) >> 1) + l;
            if (plants[0][m] == target) {
                return true;
            }
            if (plants[0][m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int col = l - 1;
        if (col >= 0) {
            System.out.println("col = " + col);
            l = 0;
            r = plants.length - 1;
            while (l <= r) {
                int m = ((r - l) >> 1) + l;
                if (plants[m][col] == target) {
                    return true;
                }
                if (plants[m][col] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        l = 0;
        r = plants.length - 1;
        while (l <= r) {
            int m = ((r - l) >> 1) + l;
            if (plants[m][0] == target) {
                return true;
            }
            if (plants[m][0] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int row = l - 1;
        if (row >= 0) {
            System.out.println("row = " + row);
            l = 0;
            r = plants[0].length - 1;
            while (l <= r) {
                int m = ((r - l) >> 1) + l;
                if (plants[row][m] == target) {
                    return true;
                }
                if (plants[row][m] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return false;
    }
}