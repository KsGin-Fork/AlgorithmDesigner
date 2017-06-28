package RecursiveAndDivision;

//设a[0 , n-1]为一个数组, k(0 <= k <= n-1)为一个非负整数 ,设计一个算法将a[0 , k-1]和a[k , n-1]对换


public class SwapArrays {
    //测试数据
    public static void main(String[] args){
        Integer[] ints = new Integer[]{1 , 2 , 3 , 4 , 5 , 6  , 7 , 8 , 9 , 13};

        SwapSplitArray(ints , -2);
        for (Integer i : ints){
            System.out.print(i + " ");
        }
        System.out.println();

        ints = new Integer[]{1 , 2 , 3 , 4 , 5 , 6  , 7 , 8 , 9 , 13};

        SwapSplitArray(ints , 3);
        for (Integer i : ints){
            System.out.print(i + " ");
        }
        System.out.println();

        ints = new Integer[]{1 , 2 , 3 , 4 , 5 , 6  , 7 , 8 , 9 , 13};

        SwapSplitArray(ints , 5);
        for (Integer i : ints){
            System.out.print(i + " ");
        }
        System.out.println();

        ints = new Integer[]{1 , 2 , 3 , 4 , 5 , 6  , 7 , 8 , 9 , 13};

        SwapSplitArray(ints , 7);
        for (Integer i : ints){
            System.out.print(i + " ");
        }
        System.out.println();

        ints = new Integer[]{1 , 2 , 3 , 4 , 5 , 6  , 7 , 8 , 9 , 13};

        SwapSplitArray(ints , 9);
        for (Integer i : ints){
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static <E> void SwapSplitArray(E[] array , int index){
        int left = 0 ;
        int right = array.length;
        int length = array.length;
        int ind = index;
        int rightLength , leftLength , count;
        E tmp;
        //总循环
        while (left < array.length && right > 0 ){
            rightLength = right - ind;
            leftLength = ind - left;
            if (rightLength <= 0 || leftLength <= 0) break;
            if (rightLength > leftLength){
                count = length / leftLength;
                for (int i = 0 ; i < leftLength ; ++i){
                    tmp = array[left + i];
                    for(int j = 0 ; j < count - 1 ; ++j){
                        array[left + j *leftLength + i] = array[left + (j+1) * leftLength + i];
                    }
                    array[left + (count - 1) * leftLength + i] = tmp;
                }
                left += (count - 1) * leftLength;
                length -= (count - 1) * leftLength;
                ind = right - length % leftLength;
            }else{
                count = length / rightLength;
                for (int i = 0 ; i < rightLength ; ++i){
                    tmp = array[left + length % rightLength + (count - 1) * rightLength + i];
                    for(int j = count - 1 ; j > 0 ; --j){
                        array[left + j * rightLength + i + length % rightLength] = array[left + (j-1) *rightLength + i + length % rightLength];
                    }
                    array[left + length % rightLength + i] = tmp;
                }
                right -= (count - 1) * rightLength;
                length -= (count - 1) * rightLength;
                ind = left + length % rightLength;
            }
        }

    }
}
