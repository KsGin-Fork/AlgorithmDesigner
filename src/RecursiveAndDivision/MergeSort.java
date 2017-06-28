package RecursiveAndDivision;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杨帆 on 2017/3/6.
 * 合并排序
 */
public class MergeSort {
    public static void main(String[] args){
        Integer[] arr = new Integer[]{1 , -1};
        MergeSort(arr);
        for (Integer i: arr) {
            System.out.print(i + " ");
        }
    }

    //所有组进行合并
    public static <T extends Comparable> void MergeSort(T[] arr){
        List<List<T>> arrays = Resolution(arr);
        for (int i = 1 ; i < arrays.size() ; i++){
            arrays.set(0 , Merge(arrays.get(0) , arrays.get(i)));
        }
        arrays.get(0).toArray(arr);
    }

    //根据原顺序将其分组
    private static <T extends Comparable> List<List<T>> Resolution(T[] arr){
        List<List<T>> arrs = new ArrayList<>();
        List<T> tmp = new ArrayList<>();
        int ptr = 1;
        tmp.add(arr[0]);
        while (ptr < arr.length){
            if (tmp.isEmpty() || arr[ptr].compareTo(tmp.get(tmp.size()-1)) >= 0){
                tmp.add(arr[ptr]);
                ptr++;
            }else{
                arrs.add(new ArrayList<>(tmp));
                tmp.clear();
            }
        }
        if (!tmp.isEmpty()) arrs.add(tmp);
        return arrs;
    }

    //两个有序组合并成一个
    private static <T extends Comparable> List<T> Merge(List<T> a , List<T> b){
        int aPtr = 0 , bPtr = 0;
        List<T> tmp = new ArrayList<>();
        while (aPtr < a.size() && bPtr < b.size()){
            if (a.get(aPtr).compareTo(b.get(bPtr)) <= 0){
                tmp.add(a.get(aPtr));
                aPtr++;
            }else{
                tmp.add(b.get(bPtr));
                bPtr++;
            }
        }
        if (aPtr < a.size()) tmp.addAll(a.subList(aPtr, a.size()));
        else if (bPtr < b.size()) tmp.addAll(b.subList(bPtr, b.size()));
        return tmp;
    }
}
