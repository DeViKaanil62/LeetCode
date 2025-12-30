import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);

        // Left-to-right: satisfies higher ratings than left neighbor
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) res[i] = res[i-1] + 1;
        }

        // Right-to-left: satisfies higher ratings than right neighbor
        int total = res[n-1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                res[i] = Math.max(res[i], res[i+1] + 1);
            }
            total += res[i];
        }

        return total;
    }
}
