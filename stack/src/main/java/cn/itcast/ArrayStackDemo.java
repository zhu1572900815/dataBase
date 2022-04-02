package cn.itcast;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:properties.properties")
public class ArrayStackDemo {

    @Value("${maxSize}")
    private int maxSize;

    @Value("${aa}")
    private int[] stack;
    private int top = -1;


    //构造函数
    public ArrayStackDemo() {

    }

    //构造器
    public ArrayStackDemo(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈-push
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满，数据无法入栈！");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈-pop, 将栈顶的数据返回
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已为空，没有数据弹出");
        }
        int tempValue = 0;
        tempValue = stack[top];
        top--;
        return tempValue;
    }

    //显示栈的情况[遍历栈]， 遍历时，需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈已为空，没有数据弹出");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("第" + (i + 1) + "个数据：" + stack[i]);
        }
    }

    //显示第一个数
    public int peek(){
        return stack[top];
    }

    //判断是不是一个运算符号
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算优先级
    //乘除的优先级最大，为1；加减的优先级最小，为0；两个都不是则为-1
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1; // 假定目前的表达式只有 +, - , * , /
        }
    }

    //计算两个数
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;// 注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }


}
