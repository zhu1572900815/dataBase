package cn.itcast.sort;

import java.util.Arrays;

public class shell {
    static int[] data={90,100,21,51,7,4,8,6,3,5};
    static int size = data.length;

    public static void main(String[] args) {
        ShellSort();
        System.out.println(Arrays.toString(data));
    }
    public static void ShellSort(){

        int gap = size/2;//获取第一次的步长和组内第一个元素位置
        int temp = 0;//暂存元素
        int i = 0;//组内第一个元素的下标
        int j = 0;//组内第二个元素的下标
        while (gap > 0){
            for (i = gap; i < size; i++) { //从每组中的后面那个元素进行比较
                temp = data[i];
                j = i - gap;
                //判断这组内的两个数
                while(j >=0 && temp < data[j]){
                    data[j + gap] = data[j];
                    j = j - gap;
                }
                data[j + gap] = temp;
            }
            gap = gap/2;
        }
    }
}
