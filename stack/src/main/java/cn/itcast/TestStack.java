package cn.itcast;

import cn.itcast.config.SpringConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class TestStack {

    //    public static void main(String[] args) {
//
//        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        ArrayStackDemo stack = app.getBean(ArrayStackDemo.class);
//        String key = "";
//        boolean loop = true; //控制是否退出菜单
//        Scanner scanner = new Scanner(System.in);
//        while(loop) {
//            System.out.println("show: 表示显示栈");
//            System.out.println("exit: 退出程序");
//            System.out.println("push: 表示添加数据到栈(入栈)");
//            System.out.println("pop: 表示从栈取出数据(出栈)");
//            System.out.println("请输入你的选择");
//            key = scanner.nextLine();
//            switch (key) {
//                case "show":
//                    stack.list();
//                    break;
//                case "push":
//                    System.out.println("请输入一个数");
//                    int value = scanner.nextInt();
//                    stack.push(value);
//                    break;
//                case "pop":
//                    try {
//                        int res = stack.pop();
//                        System.out.printf("出栈的数据是 %d\n", res);
//                    } catch (Exception e) {
//                        // TODO: handle exception
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//                case "exit":
//                    scanner.close();
//                    loop = false;
//                    break;
//                default:
//                    break;
//            }
//        }
//        System.out.println("程序退出~~~");
//    }
//    @Autowired
//    private static ArrayStackDemo numStack;
//    @Autowired
//    private static ArrayStackDemo operStack;


//    public static void main(String[] args) {
//
////        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
////        ArrayStackDemo operStack = app.getBean(ArrayStackDemo.class);
////        ArrayStackDemo numStack = app.getBean(ArrayStackDemo.class);
//        ArrayStackDemo operStack = new ArrayStackDemo(10);
//        ArrayStackDemo numStack = new ArrayStackDemo(10);
//        String expression = "31+20*6-2";
//        int length = expression.length();
//
//        int tempOper;
//        int num1 = 0;
//        int num2 = 0;
//        int res = 0;
//        int oper = 0;
//        String keepNum = ""; //用于拼接 多位数
//        for (int i = 0; i < length; i++) {
//            // 1、判断字符是不是一个符号
//            // 2、是的话，再判断符号栈是否为空
//                // 2.1、不为空，从符号栈中弹出一个符号，记为tempOper，将遍历出的符号与tempOper比较两个之间的优先级
//                    // 2.1.1、若tempOper的优先级小于等于遍历出的符号的优先级，则让该符号入符号栈
//                    // 2.1.2、若大于的话，则从数栈弹出两个数字，再结合符号栈弹出的符号，3个做运算（注意顺序），结果放入数栈，遍历出的符号放入符号栈
//                // 2.2、为空，则直接入栈
//            // 3、不是的话，直接入栈
//            char iterableRes = expression.charAt(i);
//            if(operStack.isOper(iterableRes)){
//                if(operStack.isEmpty()){
//                    operStack.push(iterableRes);
//                }else{
//                    tempOper = operStack.peek();
//                    if(operStack.priority(tempOper) > operStack.priority(iterableRes)){
//                        num1 = numStack.pop();
//                        num2 = numStack.pop();
//                        res = numStack.cal(num1, num2, operStack.pop());
//                        numStack.push(res);
//                        operStack.push(iterableRes);
//                    }else{
//                        operStack.push(iterableRes);
//                    }
//                }
//            }else{
//                keepNum +=iterableRes;
//                //如果是计算表达式的最后一位，则直接入数栈
//                if(i == length - 1){
//                    numStack.push(Integer.parseInt(keepNum));
//                }else{
//                    //多位数的数字需要结合下一位判断
//                    if(numStack.isOper(expression.charAt(i + 1))){
//                        numStack.push(Integer.parseInt(keepNum));
//                        keepNum = "";
//                    }
//                }
//            }
//        }
//
//        while(true){
//            if(operStack.isEmpty()){
//                break;
//            }
//            num1 = numStack.pop();
//            num2 = numStack.pop();
//            oper = operStack.pop();
//            res = numStack.cal(num1, num2, oper);
//            numStack.push(res);//入栈
//        }
//
//        int result = numStack.pop();
//        System.out.println(result);
//    }
//}

    public static void main(String[] args) {
        String s = "[({})]";
        HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
        hashMap.put('[', ']');
        hashMap.put('{', '}');
        hashMap.put('(', ')');
        hashMap.put('<', '>');
        int length = s.length();
        int tempOper;
        if (length <= 0 || length % 2 == 1) {
            System.out.println("输入的括号字符串不符合规定");
            return;
        }
        ArrayStackDemo arrayStackDemo = new ArrayStackDemo(10);
        for (int i = 0; i < length; i++) {
            char oper = s.charAt(i);
            if (hashMap.containsKey(oper)) {
                arrayStackDemo.push(oper);
            } else {
                tempOper = arrayStackDemo.peek();
                if (hashMap.get((char)tempOper) == oper) {
                    arrayStackDemo.pop();
                }else{
                    System.out.println("输入的括号字符串不符合规定");
                    return;
                }
            }
        }

        if(arrayStackDemo.isEmpty()){
            System.out.println("符合规定");
        }
    }
}
