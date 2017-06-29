package DynamicProgramming;

import java.util.ArrayList;

/**
 * Created by KsGin on 2017/6/28.
 */
public class MatrixChain {
    public static void main(String[] args) {
        System.out.println("Hello , Matrix chain");
        int[] p = new int[] {0 , 30 , 35 , 15 , 5 , 10 , 20 , 25};

        int result = MinChainCount(p);
        System.out.println(result);
    }

    /**
     * 最小乘次数
     *
     * @param p 需要乘的矩阵行列数列表
     * @return 最小乘次数
     */
    private static int MinChainCount(int[] p) {
        int n = p.length - 1;
        int[][] dp = new int[n + 1][n + 1];

        for (int r = 2; r < n; r++) {   //i与j的相隔大小r
            for (int i = 1 ; i <= n-r+1 ; i++){ //i
                int j = i+r-1;
                dp[i][j] = dp[i+1][j] + p[i - 1] * p[i] *p[j];
                for (int k = i + 1 ; k < j ; k++){
                    int tmp = dp[i][k] + dp[k+1][j] + p[i-1] * p[k] * p[j];
                    if (tmp > dp[i][j]){
                        dp[i][j] = tmp;
                    }
                }
            }
        }

        return dp[1][n];
    }
}
