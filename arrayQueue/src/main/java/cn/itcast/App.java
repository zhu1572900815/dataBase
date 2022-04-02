package cn.itcast;

import java.util.Scanner;

public class App 
{
    public static void main(String[] args) {
        queue qe = new queue(4);
        qe.add(5);
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        char c = ' ';
        while(flag){
            System.out.println("s : 显示队列中的所有数据");
            System.out.println("g : 把数据从队列中取出来");
            System.out.println("a : 把数据添加到队列中");
            System.out.println("h : 查看队列中的第一个数据");
            System.out.println("e : 退出程序");
            System.out.println("请选择:");
            c = scanner.nextLine().charAt(0);
            switch (c){
                case 's':
                    qe.show();
                    break;
                case 'g':
                    try {
                        qe.get();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("请输入要添加的数据");
                    int num = sc.nextInt();
                    qe.add(num);
                    break;
                case 'h':
                    try {
                        int i = qe.headQueue();
                        System.out.println("队列的第一个元素是：" + i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("结束");
    }

}
