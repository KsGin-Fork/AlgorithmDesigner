package RecursiveAndDivision;

/**
 * Created by 杨帆 on 2017/3/5.
 */
public class Ackerman {
    public static void main(String[] args){
        System.out.println(Ackerman(3 , 3));
    }

    public static int Ackerman(int m , int n){
        if (m < 0 || n < 0) return 0;
        if (m == 1 && n == 0) return 2;
        if (m == 0 && n >= 0) return 1;
        if (n == 0 && m >= 2) return m + 2;
        if (m >= 1 && n >= 1) return Ackerman(Ackerman(m - 1 , n) ,n - 1);
        return 0;
    }
}
