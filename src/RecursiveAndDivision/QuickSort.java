package RecursiveAndDivision;

/**
 * Created by ksgin on 2017/6/30.
 */
public class QuickSort {

    public static void main(String[] args){
        Integer[] is = new Integer[]{32 , 12 , 15 , 9 , 45 , 16 , 234 ,  2  , 11  , 90};
        QuickSort( is, 0 , 9);
        for (Integer i : is){
            System.out.print(i + " ");
        }
    }

    public static <E extends Comparable> void QuickSort(E[] es, int l, int r) {
        if (l < 0 || r > es.length-1 || l >= r) return;     //只剩一个元素或者没有元素时直接退出

        int ls = l , rs = r;
        int md = ls; //中值索引 ， 赋值为l
        while (true){
            while (ls < r && es[ls].compareTo(es[md]) < 0) ls++;
            while (es[rs].compareTo(es[md]) > 0) rs--;
            if (ls >= rs) break;
            Swap(es , ls , rs);
        }

        es[rs] = es[md];

        QuickSort(es, l, rs-1);
        QuickSort(es, rs + 1, r);
    }

    private static<E> void Swap(E[] es, int ls, int rs) {
        E tmp = es[ls];
        es[ls] = es[rs];
        es[rs] = tmp;
    }
}
