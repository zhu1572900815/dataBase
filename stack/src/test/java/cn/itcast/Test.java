package cn.itcast;
import java.util.HashMap;

public class Test {
    @org.junit.Test
    public void test01(){
        System.out.println('+' > 98);
        System.out.println((int)'+');
        System.out.println((int)'-');
        String left = "[({<";
        HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
        hashMap.put('[', ']');
        hashMap.put('{', '}');
        hashMap.put('(', ')');
        hashMap.put('<', '>');
        System.out.println(left.contains(")"));
        System.out.println(hashMap.get('['));
    }


}
