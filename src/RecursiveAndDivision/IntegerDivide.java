package RecursiveAndDivision;

/**
 * Created by 杨帆 on 2017/3/3.
 * 整数划分
 */
public class IntegerDivide {
    public static void main(String[] args){
        System.out.println(IntegerDivide(6 , 6));
    }

    public static int IntegerDivide(int number , int max){
        if (number <= 0 || max <= 0) return 0;
        if (number == 1 || max == 1) return 1;
        if (number < max) return IntegerDivide(number , number);
        if (number == max) return IntegerDivide(number , max - 1) + 1;
        return IntegerDivide(number , max - 1) + IntegerDivide(number - max, max);
    }
}
