package DynamicProgramming;

/**
 * File Name : MaxSubSum.cpp
 * Created by KsGin on 2017/6/28.
 */
public class MaxSubSum {
    public static void main(String[] args){
        System.out.println("MaxSubSum = " +  MaxMatrixSubSum(new int[][]{{0 , 4}, {-2 , -8} , {3 , 7}}));
    }

    /**
     * 最大字段 简单dp   简单算法强行套上dp......
     * @param nums 数组
     * @return 最大和
     */
    private static int MaxSum(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n];
        int max = 0;
        for (int i = 0 ; i < n ; i++){  //为dp赋初值
            dp[i][i] = nums[i];
            if (dp[i][i] > max) max = dp[i][i];
        }

        for (int r = 1 ; r < n ; r++){
            for (int i = 0 ; i < n - r ; i++){
                dp[i][i+r] = dp[i][i+r-1] + nums[i+r];
                if (dp[i][i+r] > max) max = dp[i][i+r];
            }
        }

        return max;
    }

    /**
     * 最大子段 dp
     * @param nums 数组
     * @return 最大值
     */
    private static int MaxSumReview(int[] nums){
        int sum = 0;
        int b = 0;
        for (int num : nums) {
            if (b > 0) b += num;
            else b = num;
            if (b > sum) sum = b;
        }
        return sum;
    }

    /**
     * 最大m子段和问题
     * @param nums 数组
     * @return 最大和
     */
    private static int MaxMulSubSum(int[] nums , int m){
        int n = nums.length - 1;
        if (m > n || m < 0) return 0;
        int[] p1 = new int[n+1];
        int[] p2 = new int[n+1];

        for (int i = 1 ; i <= m ; i++){
            p1[i] = p1[i-1] + nums[i];
            p2[i-1] = p1[i];
            int max = p1[i];
            for (int j = i+1 ; j <= i+n-m ; j++){
                p1[j] = (p1[j-1] > p2[j-1] ? p1[j-1] : p2[j-1]) + nums[j];
                p2[j-1] = max;
                if (max < p1[j])  max = p1[j];
            }
            p2[i+n-m] = max;
        }

        int sum = 0;
        for (int i = m ; i <= n ; i++){
            if (sum < p1[i]) sum = p1[i];
        }

        return sum;
    }

    /**
     * 最大子矩阵和
     * @param nums 矩阵
     * @return 最大值
     */
    private static int MaxMatrixSubSum(int[][] nums){
        int m = nums.length-1;
        int n = nums[0].length-1;
        int sum = 0;
        int[] b = new int[n+1];
        for (int i = 0 ; i <= m ; i++){
            for (int k = 1; k <= n; k++){
                b[k] = 0;
            }
            for (int j = i ; j <= m; j++){
                for (int k = 1 ; k <= n; k++){
                    b[k] += nums[j][k];
                }
                int max = MaxSumReview(b);
                if (max > sum) sum = max;
            }
        }
        return sum;
    }
}
