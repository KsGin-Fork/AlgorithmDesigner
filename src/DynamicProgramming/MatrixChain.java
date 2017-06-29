package DynamicProgramming;

import java.util.ArrayList;

/**
 * Created by KsGin on 2017/6/28.
 */
public class MatrixChain {
    public static void main(String[] args){
        System.out.println("Hello , Matrix chain");
        ArrayList s = new ArrayList(){{     //Java双括号初始化
            add(30);
            add(35);
            add(15);
            add(5);
            add(10);
            add(20);
            add(25);
        }};
        MinChainCount(s);
    }

    /**
     * 最小乘次数
     * @param list 需要乘的矩阵行列数列表
     * @return 最小乘次数
     */
    public static int MinChainCount(ArrayList list){
        int size = list.size();
        int[][] dp = new int[size+1][size+1];

        for (int i = 1 ; i < size+1 ; i++){
            for (int j = i + 1 ; j < size+1 ; j++){
                for (int k = i ; k < j ; k++){

                }
            }
            System.out.println();
        }



        return 0;
    }
}
