package cn.itcast;

public class eightQueen {
    //定义一个max，表示有多少个皇后
    static int max = 8;
    //定义一个一维数组，表示皇后最后放入的位置
    static int[] locationArray = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        eightQueen eightQueen = new eightQueen();
        eightQueen.set(0);
        System.out.println("总共迭代了"+count+"次" );
    }


    private  void set(int n){
        //如果n等于8，则表示前面8个皇后已经摆放完成，就可以退出程序，输出结果
        if(n == max){
            showResult();
            return;
        }
        //摆放第n个皇后，需要从第0列直到第7列依次尝试，知道合适为止
        for (int i = 0; i < max; i++) {
            locationArray[n] = i;
            if (judge(n)){
                set(n+1);
            }
        }
    }
    /**
     * 判断第i个皇后摆放的位置是否合理
     * @param i 既代表第几个皇后，又代表皇后摆放的位置的列数
     * @return
     */
    private  boolean judge(int i){
        count++;
        for (int j = 0; j < i; j++) {
            if(locationArray[j] == locationArray[i] || Math.abs(i - j) == Math.abs(locationArray[i] - locationArray[j])){
                return false;
            }
        }
        return true;
    }
    /**
     * 输出最后摆放的结果
     */
    private  void showResult(){
        for (int i = 0; i < locationArray.length; i++) {
            System.out.print(locationArray[i] + " ");
        }
        System.out.println();
    }
}
