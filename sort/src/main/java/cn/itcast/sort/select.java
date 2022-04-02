package cn.itcast.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class select {
    public static void main(String[] args) {
        int[] array = new int[80000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 8000000);
        }
        int temp = 0;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date);
        System.out.println("排序前：");
        System.out.println(date1Str);
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }


        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后：");
        System.out.println(date2Str);
    }
}
