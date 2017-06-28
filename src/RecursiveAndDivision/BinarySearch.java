package RecursiveAndDivision;

/**
 * Created by 杨帆 on 2017/3/5.
 */
public class BinarySearch{
    public static void main(String[] args){
        System.out.println(BinarySearch.BinarySearch0(new Integer[]{1 , 2 , 3 ,  4, 4 , 4, 4, 5} , 1));
        System.out.println(BinarySearch.BinarySearch0(new Integer[]{1 , 2 , 3 ,  4, 4 , 4, 4, 5} , 3));
        System.out.println(BinarySearch.BinarySearch0(new Integer[]{1 , 2 , 3 ,  4, 4 , 4, 4, 5} , 5));
        System.out.println(BinarySearch.BinarySearch0(new Integer[]{1 , 2 , 3 ,  4, 4 , 4, 4, 5} , 15));
        System.out.println(BinarySearch.BinarySearch0(new Integer[]{1 , 2 , 3 ,  4, 4 , 4, 4, 5} , -15));
        System.out.println(BinarySearch.BinarySearch0(new Integer[]{1 , 2 , 3 ,  4, 4 , 4, 4, 5 , 6} , 1));
        System.out.println(BinarySearch.BinarySearch0(new Integer[]{1 , 2 , 3 ,  4, 4 , 4, 4, 5 , 6} , 3));
        System.out.println(BinarySearch.BinarySearch0(new Integer[]{1 , 2 , 3 ,  4, 4 , 4, 4, 5 , 6} , 6));
        System.out.println(BinarySearch.BinarySearch0(new Integer[]{1 , 2 , 3 ,  4, 4 , 4, 4, 5 , 6} , 16));
        System.out.println(BinarySearch.BinarySearch0(new Integer[]{1 , 2 , 3 ,  4, 4 , 4, 4, 5 , 6} , -16));
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println(BinarySearch.BinarySearch5(new Integer[]{1 , 2 , 3 , 4 , 4 , 4, 4, 5} , 1));
        System.out.println(BinarySearch.BinarySearch5(new Integer[]{1 , 2 , 3 , 4 , 4 , 4, 4, 5} , 3));
        System.out.println(BinarySearch.BinarySearch5(new Integer[]{1 , 2 , 3 , 4 , 4 , 4, 4, 5} , 5));
        System.out.println(BinarySearch.BinarySearch5(new Integer[]{1 , 2 , 3 , 4 , 4 , 4, 4, 5} , 15));
        System.out.println(BinarySearch.BinarySearch5(new Integer[]{1 , 2 , 3 , 4 , 4 , 4, 4, 5} , -15));
        System.out.println(BinarySearch.BinarySearch5(new Integer[]{1 , 2 , 3 , 4 , 4 , 4, 4, 5 , 6} , 1));
        System.out.println(BinarySearch.BinarySearch5(new Integer[]{1 , 2 , 3 , 4 , 4 , 4, 4, 5 , 6} , 3));
        System.out.println(BinarySearch.BinarySearch5(new Integer[]{1 , 2 , 3 , 4 , 4 , 4, 4, 5 , 6} , 6));
        System.out.println(BinarySearch.BinarySearch5(new Integer[]{1 , 2 , 3 , 4 , 4 , 4, 4, 5 , 6} , 16));
        System.out.println(BinarySearch.BinarySearch5(new Integer[]{1 , 2 , 3 , 4 , 4 , 4, 4, 5 , 6} , -16));
    }

    //我自己写的
    public static <T extends Comparable> int BinarySearch0(T[] arr , T k){
        int min = 0 , max = arr.length - 1;
        int mid;
        while (min <= max){
            mid = (min + max) / 2;
            if (arr[mid].compareTo(k) < 0){
                min = mid + 1;
            }else if(arr[mid].compareTo(k) > 0){
                max = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    //课后1 错误
    public static <T extends Comparable> int BinarySearch1(T[] arr , T k){
        int min = 0 , max = arr.length - 1;
        int mid;
        while (min <= max){
            mid = (min + max) / 2;
            if (arr[mid].compareTo(k) < 0){
                min = mid;
            }else if(arr[mid].compareTo(k) > 0){
                max = mid;
            }else{
                return mid;
            }
        }
        return -1;
    }

    //课后2 错误
    public static <T extends Comparable> int BinarySearch2(T[] arr , T k){
        int min = 0 , max = arr.length - 1;
        int mid;
        while (min < max - 1){
            mid = (min + max) / 2;
            if (k.compareTo(arr[mid]) < 0) max = mid;
            else min = mid;
        }
        if (k.compareTo(arr[min]) == 0) return min;
        else return -1;
    }

    //课后3 错误
    public static <T extends Comparable> int BinarySearch3(T[] arr , T k){
        int min = 0 , max = arr.length - 1;
        while (min + 1 != max){
            int mid = (min + max) / 2;
            if (k.compareTo(arr[mid]) >= 0) min = mid;
            else max = mid;
        }
        if (k.compareTo(arr[min]) == 0) return min;
        else return -1;
    }

    //课后4 错误
    public static <T extends Comparable> int BinarySearch4(T[] arr , T k){
        if (arr.length > 0 && k.compareTo(arr[0]) >= 0){
            int min = 0 , max = arr.length - 1;
            while (min < max){
                int mid = (min + max) / 2;
                if (k.compareTo(arr[mid]) < 0) max = mid - 1;
                else min = mid;
            }
            if (k.compareTo(arr[min]) == 0) return min;
        }
        return -1;
    }

    //课后5 正确
    public static <T extends Comparable> int BinarySearch5(T[] arr , T k){
        if (arr.length > 0 && k.compareTo(arr[0]) >= 0){
            int min = 0 , max = arr.length - 1;
            while (min < max){
                int mid = (min + max + 1) / 2;
                if (k.compareTo(arr[mid]) < 0) max = mid - 1;
                else min = mid;
            }
            if (k.compareTo(arr[min]) == 0) return min;
        }
        return -1;
    }

    //课后6 正确
    public static <T extends Comparable> int BinarySearch6(T[] arr , T k){
        if (arr.length > 0 && k.compareTo(arr[0]) >= 0){
            int min = 0 , max = arr.length - 1;
            while (min < max){
                int mid = (min + max + 1) / 2;
                if (k.compareTo(arr[mid]) < 0) max = mid - 1;
                else min = mid + 1;
            }
            if (k.compareTo(arr[min]) == 0) return min;
        }
        return -1;
    }

    //课后7 错误
    public static <T extends Comparable> int BinarySearch7(T[] arr , T k){
        if (arr.length > 0 && k.compareTo(arr[0]) >= 0){
            int min = 0 , max = arr.length - 1;
            while (min < max){
                int mid = (min + max + 1) / 2;
                if (k.compareTo(arr[mid]) < 0) max = mid;
                else min = mid + 1;
            }
            if (k.compareTo(arr[min]) == 0) return min;
        }
        return -1;
    }
}
