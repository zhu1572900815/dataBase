package cn.itcast.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class quick {
    public static void main(String[] args) {
        int[] array = new int[80000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 8000000);
        }
//        int[] array = { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 ,0,0,0,0};
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date);
        System.out.println("排序前：");
        System.out.println(date1Str);
        quickSort(array, 0, array.length - 1);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后：");
        System.out.println(date2Str);
        System.out.println(Arrays.toString(array));
    }

    /**
     *
     * @param arr 待排序数组
     * @param left 待排序数组区间的初始下标
     * @param right 待排序数组区间的末尾下标
     */
    public static void quickSort(int[] arr,int left, int right) {
        //当left大于等于right时，说明已经查询完毕，可以退出
        if(left >= right){
            return;
        }
        //找到中轴位置
        int pivot = partion(arr,left,right);
        //对中轴的左右两边继续进行排序
        quickSort(arr,left,pivot - 1);
        quickSort(arr,pivot + 1,right);
    }

    private static int partion(int[] arr, int left, int right) {
        //定义一个标准值
        int num = arr[left];
        //定义查询时的左右索引
        int i = left;
        int j = right;
        while(i < j){
            //从右往左，如果遇到arr[i]小于num的值，则停止
            while(i < j && arr[j] >= num){
                j--;
            }
            //从左往右，如果遇到arr[i]大于num的值，则停止
            while(i < j && arr[i] <= num){
                i++;
            }
            //找到两个值后，进行交换
            if(i < j){
                swap(arr,i,j);
            }
        }
        swap(arr,i,left);
        return j;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


