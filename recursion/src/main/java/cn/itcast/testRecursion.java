package cn.itcast;

public class testRecursion {
    public static void main(String[] args) {
        test(4);
        int factorialResult = factorial(10);
        System.out.println(factorialResult);
    }

    //打印问题.
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println(n);
    }

    //阶乘问题


    public static int factorial(int n) {
        if (n != 1) {
            return factorial(n - 1) * n;
        } else {
            return 1;
        }
    }
}
