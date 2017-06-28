package RecursiveAndDivision;

/**
 * Created by 杨帆 on 2017/3/3.
 * 全排列
 */
public class FullArrangement {
    public static void main(String[] args){
        FullArrangement("ABC".toCharArray() , 0);
    }

    public static void FullArrangement(char[] str , int k){
        if (k == str.length){
            for (int i = 0 ; i < str.length ; ++i) {
                System.out.print(str[i]);
            }
            System.out.println();
        } else {
            for (int i = k ; i < str.length ; ++i){
                Swap(str , k , i);
                FullArrangement(str , k + 1);
                Swap(str , k , i);
            }
        }
    }

    private static void Swap(char[] arr, int k , int i) {
        char t = arr[k] ;
        arr[k] = arr[i] ;
        arr[i] = t;
    }
}
