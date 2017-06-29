package DynamicProgramming;

/**
 * Created by KsGin on 2017/6/28.
 */
public class ZeroOnePackage {
    public static void main(String[] args){
        System.out.println("Hello , ZeroOnePackage");
    }

    public static int Knapsack(int c /*最大容量*/ , int[] w /*物品列表*/ , int[] s /*结果列表*/){
        int n = w.length;
        int[][] dp = new int[c][n];
        int bestw = 0;
        int curc = c;
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < c ; j++){
                if (j < w[i]) {
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return 0;
    }
}
