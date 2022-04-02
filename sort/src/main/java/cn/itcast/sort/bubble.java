package cn.itcast.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class bubble {
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

        bubbleSort(array);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后：");
        System.out.println(date2Str);
    }

    public static void bubbleSort(int[] array){
        int temp = 0;
        boolean flag = false;
        for (int j = 0; j < array.length -1; j++) {
            for (int i = 0; i < array.length - 1 - j; i++) {
                if(array[i] > array[i + 1]){
                    flag = true;
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i +1] = temp;
                }
            }
            if(flag == true){
                flag = false;
            }
        }
    }
}
