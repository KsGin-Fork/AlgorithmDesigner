package DynamicProgramming;

import static java.lang.System.arraycopy;

/**
 * Created by KsGin on 2017/6/29.
 */
public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] result = new int[6];
        int max = TrackBack(10 ,
                new int[]{0, 3 , 5 , 4 , 2 , 5} ,
                new int[] { 0 ,2 , 3 , 4 , 5  , 1 } ,
                result);
        System.out.println("max = " + max);
        for (int r = 1 ; r < result.length ; r++){
            System.out.println(result[r]);
        }
    }

    private static <T> int TrackBack(int c /*最大容量*/, int[] w /*价值列表*/,
                                      int[] v /*体积列表*/, int[] re /*结果数组*/) {
        int n = w.length - 1;
        int[][] dp = new int[n+1][c+1];
        int cc = c;
        Knapsack(cc , w , v , dp);   //求解dp数组
        for (int i = 0; i < n; i++) {
            if (dp[i][cc] == dp[i + 1][cc]) {
                re[i] = 0;
            } else {
                re[i] = 1;
                cc -= w[i];
            }
            re[n] = (dp[n][cc]) == 1 ? 1 : 0;
        }
        return dp[1][c];
    }

    private static void Knapsack(int c /*最大容量*/, int[] w /*重量列表*/,
                                 int[] v /*价值列表*/, int[][] dp /*dp数组*/) {
        int n = w.length - 1;
        int jMax = min(w[n] - 1, c);
        for (int j = w[n]; j <= c; j++) {
            dp[n][j] = v[n];
        }
        for (int i = n - 1; i > 1; i--) {
            jMax = min(w[i] - 1, c);
            for (int j = 0 ; j <= jMax ; j++){
                dp[i][j] = dp[i+1][j];
            }
            for (int j = w[i]; j <= c; j++) {
                dp[i][j] = max(dp[i + 1][j], dp[i + 1][j - w[i]] + v[i]);  //problem 1
            }
        }
        dp[1][c] = dp[2][c];
        if (c >= w[1]) {
            dp[1][c] = max(dp[1][c], dp[2][c - w[1]] + v[1]);
        }
    }

    private static <T extends Comparable> T min(T a, T b) {
        return a.compareTo(b) < 0 ? a : b;
    }

    private static <T extends Comparable> T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }
}
