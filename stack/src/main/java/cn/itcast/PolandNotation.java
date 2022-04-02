package cn.itcast;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //(3+4)×5-6对应的逆波兰表达式为3 4 + 5 × 6 - ，计算该逆波兰表达式
        String expression = "3 4 + 5 * 6 -";
        ArrayList<String> trsExp = transferExpression(expression);
        int result = calculation(trsExp);
        System.out.println(toInfixExpressionList("(30+40)*5-6"));
        System.out.println(infixTransferToSuffix(toInfixExpressionList("1+((2+3)*4)-5")));
    }

    /**
     * 将后缀表达式转化为一个ArrayList集合
     * @param expression
     * @return ArrayList<String>
     */
    public static ArrayList<String> transferExpression(String expression) {
        ArrayList<String> strings = new ArrayList<>();
        String[] s = expression.split(" ");
        for (String tempS : s) {
            strings.add(tempS);
        }
        return strings;
    }

    /**
     * 计算后缀表达式
     * @param arrayList
     * @return
     */
    public static int calculation(ArrayList<String> arrayList){

        int result = 0;
        Stack<Integer> integerStack = new Stack<Integer>();
        for (String s : arrayList) {
            if(s.matches("^[0-9]*$")) //判断该字符串是不是一个数字，是一个数字则进入栈中
            {
                integerStack.push(Integer.parseInt(s));
            }else    //不是一个数字，则有可能是一个符号，需要从栈中弹出两个数进行计算
            {
                int num1 = integerStack.pop();
                int num2 = integerStack.pop();
                if("+".equals(s)){
                    result = num1 + num2;
                }else if("-".equals(s)){
                    result = num2 - num1;
                }else if("*".equals(s)){
                    result = num2 * num1;
                }else if("/".equals(s)){
                    result = num2 / num1;
                }else {
                    throw  new RuntimeException("没有该运算符");
                }
                integerStack.push(result);
            }
        }
        return integerStack.peek();
    }

    /**
     * 将一个字符串转换为ArrayList<String>集合
     * @param s
     * @return
     */
    public static ArrayList<String> toInfixExpressionList(String s){
        // 定义一个集合用来存放转化后的逆波兰表达式
        ArrayList<String> strings = new ArrayList<>();
        // 索引
        int index = 0;

        // 通过遍历获得的每一个字符
        char tempChar = '_';
        do{
            //如果不是一个数字，则需要直接加入到集合中
            if((tempChar=s.charAt(index)) < 48 ||  (tempChar=s.charAt(index)) > 57){
                strings.add("" + tempChar);
                index++; //i需要后移
            }else{
                // 字符串拼接，考虑到多位数的情况
                StringBuilder stringBuilder = new StringBuilder();
                while(index < s.length() && (tempChar=s.charAt(index)) >= 48 && (tempChar=s.charAt(index)) <= 57) {
                    stringBuilder.append(tempChar);
                    index++;
                }
                strings.add(stringBuilder.toString());
            }
        }while(index < s.length());
        return strings;
    }

    public static ArrayList<String> infixTransferToSuffix(ArrayList<String> infixArrayList){
        Stack<String> s1 = new Stack<>();
        ArrayList<String> s2 = new ArrayList<>();
        for (String item : infixArrayList) {
            if(item.matches("^[0-9]*$")){  // 遇到操作数
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                while(s1.size() > 0 && !(s1.peek().equals("("))){  //如果碰到是一个“（”则需要在s1栈中存有数据和栈顶元素不是“）”的情况下,执行以下操作
                    s2.add(s1.pop());
                }
                if(s1.size() > 0){
                    s1.pop(); //栈顶元素是“(”，需要把它去除
                }
            }else if(item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")){  //遇到运算符
                while((s1.size() != 0) && (judgePriority(item) <= judgePriority(s1.peek()))){
                    s2.add(s1.pop());
                }
                if((s1.size() == 0) || judgePriority(s1.peek()) < judgePriority(item)){
                    s1.push(item);
                }
            }
        }

        while(s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }

    public static int judgePriority(String symbol){
        int ADD = 1;
        int SUB = 1;
        int MUL = 2;
        int DIV = 2;
        int result = 0;
        switch (symbol) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符" + symbol);
                break;
        }
        return result;
    }
}



