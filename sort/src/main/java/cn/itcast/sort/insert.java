package cn.itcast.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class insert {
    public static void main(String[] args) {
        int[] array = new int[80000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 8000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date);
        System.out.println("排序前：");
        System.out.println(date1Str);
        InsertSort(array);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后：");
        System.out.println(date2Str);

    }

    /**
     * 插入排序
     * 两个序列 一个无序 一个有序
     * @param array
     * @return
     */
    public static int[] InsertSort(int[] array){
        int num = 0;
        int temp = 0;
        for (int i = 1; i < array.length; i++) { //总共需要的比较次数
            for (int j = 0; j < i; j++) { //将int[i]与它的前面i个数进行比较
                if(array[i] < array[j]){ //如果int[i]比它前面的一个数小的话，则需要将这些数依次向后移动
                    temp = array[i];
                    for (int k = i; k > j; k--) {
                        array[i] = array[i-1];
                    }
                    array[j] = temp;
                }
            }
            //System.out.println("第"+(++num)+"次排序：" +Arrays.toString(array));
        }
        return array;
    }
}
