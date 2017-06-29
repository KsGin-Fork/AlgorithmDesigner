package DynamicProgramming;

/**
 * File Name : ${FILENAME}
 * Created by KsGin on 2017/6/28.
 */
public class MaxSubSum {
    public static void main(String[] args){
        System.out.println("MaxSubSum = " + MaxSumReview(new int[]{4, -2 , -8 , 3 , 7}));
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
}
