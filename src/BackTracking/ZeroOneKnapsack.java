package BackTracking;

/**
 * Created by ksgin on 2017/6/29.
 */
public class ZeroOneKnapsack {
    static class elem implements Comparable {  //背包内容
        int w; //重量
        int v; //价值

        public elem(int w, int v) {     //构造方法
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Object o) {   //比较函数
            if (((elem) o).w == w) return 0;
            if (((elem) o).w > w) return -1;
            return 1;
        }
    }

    elem[] elems;   //物品数组
    int n;          //物品个数
    int[] bestx;    //最优解集
    int[] cx;       //当前解集
    int bestp;      //最优价值
    int cp;         //当前价值
    int cw;         //当前重量
    int cc;         //最大容量

    void BackTrack(int t) {     //回溯函数
        if (t >= n) {
            if (cp > bestp) {    //如果当前价值大于最大价值 ， 则更新最大价值和解集
                bestp = cp;
                bestx = cx;
            }
            cx = new int[n];
            return;
        }
        if (cw + elems[t].w <= cc) {
            cx[t] = 1;          //修改解集
            cw += elems[t].w;   //修改当前重量
            cp += elems[t].v;   //修改当前价值
            BackTrack(t + 1);
            cw -= elems[t].w;   //修改当前重量
            cp -= elems[t].v;   //修改当前价值
        }
        if (Bound(t + 1) > bestp) {
            cx[t] = 0;
            BackTrack(t + 1);
        }
    }

    private int Bound(int i) {   //限界方法
        int sc = cc - cw;
        int gp = cp;
        while (i < n && sc >= elems[i].w) {
            sc -= elems[i].w;
            gp += elems[i].v;
            i++;
        }
        if (i < n) {     //如果还没装满 , 则使用它的单位价值来填满
            gp += elems[i].v * sc / elems[i].w;
        }
        return gp;
    }

    public static void main(String[] args) {
        ZeroOneKnapsack s = new ZeroOneKnapsack();
        s.elems = new elem[]{
                new elem(3, 5),
                new elem(6, 12),
                new elem(4, 6),
                new elem(5, 7),
                new elem(10, 14)
        };
        s.n = 5;
        s.bestp = 0;
        s.bestx = new int[s.n];
        s.cc = 10;
        s.cw = 0;
        s.cp = 0;
        s.cx = new int[s.n];
        s.BackTrack(0);
        System.out.println(s.bestp);
        for (int i = 0 ; i < s.n ; i++){
            System.out.print(s.bestx[i] + " ");
        }
    }
}
