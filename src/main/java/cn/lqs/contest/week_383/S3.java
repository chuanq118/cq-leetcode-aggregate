package cn.lqs.contest.week_383;

public class S3 {

    public int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length;
        int n = image[0].length;

        int[][] regions = new int[m - 2][n - 2];
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (Math.abs(image[i][j] - image[i][j + 1]) > threshold) {
                    regions[i][j] = -1;
                    continue;
                }
                if (Math.abs(image[i][j + 1] - image[i][j + 2]) > threshold) {
                    regions[i][j] = -1;
                    continue;
                }
                if (Math.abs(image[i + 1][j] - image[i + 1][j + 1]) > threshold) {
                    regions[i][j] = -1;
                    continue;
                }

                if (Math.abs(image[i + 1][j + 1] - image[i + 1][j + 2]) > threshold) {
                    regions[i][j] = -1;
                    continue;

                }
                if (Math.abs(image[i + 2][j] - image[i + 2][j + 1]) > threshold) {
                    regions[i][j] = -1;
                    continue;

                }
                if (Math.abs(image[i + 2][j + 1] - image[i + 2][j + 2]) > threshold) {
                    regions[i][j] = -1;

                    continue;

                }

                if (Math.abs(image[i][j] - image[i + 1][j]) > threshold) {
                    regions[i][j] = -1;

                    continue;
                }


                if (Math.abs(image[i + 1][j] - image[i + 2][j]) > threshold) {
                    regions[i][j] = -1;

                    continue;

                }
                if (Math.abs(image[i][j + 1] - image[i + 1][j + 1]) > threshold) {
                    regions[i][j] = -1;
                    continue;

                }
                if (Math.abs(image[i + 1][j + 1] - image[i + 2][j + 1]) > threshold) {
                    regions[i][j] = -1;

                    continue;

                }
                if (Math.abs(image[i][j + 2] - image[i + 1][j + 2]) > threshold) {
                    regions[i][j] = -1;

                    continue;
                }


                if (Math.abs(image[i + 1][j + 2] - image[i + 2][j + 2]) > threshold) {
                    regions[i][j] = -1;

                    continue;

                }
                int average = (image[i][j] + image[i][j + 1] + image[i][j + 2] + image[i + 1][j] + image[i + 1][j + 1] + image[i + 1][j + 2] + image[i + 2][j] + image[i + 2][j + 1] + image[i + 2][j + 2]) / 9;
                regions[i][j] = average;
            }
        }

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int rbi = Math.min(i, m - 3);
                int rbj = Math.min(j, n - 3);
                int lti = Math.max(i - 2, 0);
                int ltj = Math.max(j - 2, 0);
                int res = 0;
                int count = 0;
                for (int k1 = lti; k1 <= rbi; k1++) {
                    for (int k2 = ltj; k2 <= rbj; k2++) {

                        if (regions[k1][k2] != -1) {
                            count++;
                            res += regions[k1][k2];
                        }
                    }
                }
                ans[i][j] = count > 0 ? res / count : image[i][j];
            }
        }

        return ans;
    }
}
