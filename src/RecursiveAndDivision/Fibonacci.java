package RecursiveAndDivision;

/**
 * Created by 杨帆 on 2017/3/3.
 * fibonacci 数列
 */
public class Fibonacci {
    public static void main(String[] args){
        for (int i = 0 ; i < 10 ; ++i){
            System.out.println(Fibonacci(i));
        }
    }
    
    public static long Fibonacci(long n){
        if (n == 1 || n == 0) return 1 ;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
