import org.junit.Test;

import java.io.*;

public class test01 {

    @Test
    public void testSpareArray() throws IOException {

        int[][] ints = new int[10][10];
        ints[0][0] = 1;
        ints[1][5] = 2;
        ints[2][3] = 1;
        ints[5][9] = 1;
        System.out.println("原数组:");
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }

        //遍历二维数组，得到有效数据个数
        int validNumbers = 0;
        for (int[] anInt : ints) {
            for (int i : anInt) {
                if(i != 0){
                    validNumbers++;
                }
            }
        }
       //根据有效数字的个数创建稀疏数组
        Integer[][] sparseArray = new Integer[validNumbers+1][3];
        sparseArray[0][0] = 10;
        sparseArray[0][1] = 10;
        sparseArray[0][2] = 11;
        int row = 0;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(ints[i][j] != 0){
                    row++;
                    sparseArray[row][0] = i;
                    sparseArray[row][1] = j;
                    sparseArray[row][2] = ints[i][j];
                }
            }
        }
        //输出稀疏数组
        BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
        for (Integer[] sparseArraya : sparseArray) {
            for (Integer i : sparseArraya) {
                bw.write(i + "\t");
            }
            bw.write( "\r\n");
        }
        bw.close();
    }
    @Test
    public void sparseTotwo() throws IOException {
        File file = new File("a.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        int sum = 0;
        int totalRow = 0;
        String line = " ";

        while((line = br.readLine()) != null){
            String[] split = line.split("\t");
            sum += split.length;
        }
        totalRow = sum/3;
        System.out.println("稀疏数组的总行数为：" + totalRow);
        BufferedReader brr = new BufferedReader(new FileReader(file));
        //建立一个稀疏数组
        int[][] sparseArray = new int[totalRow][3];
        String line1 = brr.readLine();
        String[] split = line1.split("\t");
        sparseArray[0][0] = Integer.parseInt(split[0]);
        sparseArray[0][1] = Integer.parseInt(split[1]);
        sparseArray[0][2] = Integer.parseInt(split[2]);
        int row = 0;
        int list = 0;
        while((line = brr.readLine()) != null){
            String[] split1 = line.split("\t");
            row++;
            list = 0;
            for (String s : split1) {
                sparseArray[row][list] = Integer.parseInt(s);
                list++;
            }
        }
        int[][] twoArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for(int i = 1; i < totalRow; i++){
            int tempRow = sparseArray[i][0];
            int tempList = sparseArray[i][1];
            int value = sparseArray[i][2];
            twoArray[tempRow][tempList] = value;
        }

        System.out.println("二维数组");
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.printf("%d\t",twoArray[i][j]);
            }
            System.out.println();
        }


    }
}
