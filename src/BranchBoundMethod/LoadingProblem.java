package BranchBoundMethod;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ksgin on 2017/6/29.
 */
public class LoadingProblem { /*装载问题*/  /*分支限界法*/

    public static void main(String[] args) {
        int[] w = new int[] {0 , 34 , 23 , 15 , 31};
        int result = MaxLoading(w , 100 , 4);
        System.out.println("Result=" + result);
    }

    /*入队方法*/
    static int EnQueue(
            Queue<Integer> Q    /*队列*/,
            int wt              /*当前价值*/,
            Integer bestw           /*最大价值*/,
            int i               /*当前层数*/,
            int n               /*最大层数*/) {
        if (i == n) {
            if (wt > bestw) {
                return wt;    //返回最大价值
            }
        }else{
            Q.offer(wt);
        }
        return bestw;
    }

    static int MaxLoading(int[] w /*数组*/ , int c /*最大载重*/, int n /*数组元素个数*/) {
        Queue<Integer> Q = new LinkedList<>();   //活节点队列
        Q.offer(-1);                 //添加-1
        int i = 1;                      //当前节点所在的层数
        int Ew = 0;                     //当前节点时的载重量
        int bestw = 0;                  //当前最优载重量

        //搜索
        while (true){
            if (Ew + w[i] <= c){                    //代表此路可走，左儿子节点入队
                bestw = EnQueue(Q , Ew + w[i] , bestw , i , n);
            }

            bestw = EnQueue(Q , Ew , bestw , i , n);        //左子树永远可行

            Ew = Q.poll();             //删除队列中第一个元素

            if (Ew == -1){        //如果到达同层节点尾部的-1,则删除-1，层数+1，并且队尾添加新的-1（下一层节点尾部）
                if (Q.isEmpty()) return bestw;   //若队列为空  则返回bestw

                Q.offer(-1);

                Ew = Q.poll();

                i++;    //层数+1
            }
        }
    }
}
