package BackTracking;

/**
 * Created by ksgin on 2017/6/29.
 */
public class NQueen {

    public static void main(String[] args){
        System.out.println(SovleNQueen(8));
    }

    public static long SovleNQueen(int n) {   /*N皇后解*/
        Queen x = new Queen();
        x.n = n;
        x.sum = 0;
        x.x = new int[n+1];
        x.BackTrack(1);
        return x.sum;
    }


    static class Queen {        /*皇后子类*/

        int n;         //皇后个数
        int[] x;        //解集
        long sum;       //当前已找到的可行方案数

        boolean Place(int k) {    //可行性约束  1.同行 2.同列 3.同斜线
            for (int i = 1; i < k; i++) {
                if (Math.abs(k - i) == Math.abs(x[k] - x[i]) || x[i] == x[k]) {
                    return false;
                }
            }
            return true;
        }

        void BackTrack(int t) {        //回溯方法   递归法
            if (t > n) {
                sum++;
            } else {
                for (int i = 1; i <= n ; i++){
                    x[t] = i;
                    if (Place(t)) BackTrack(t+1);
                }
            }
        }

    }
}
