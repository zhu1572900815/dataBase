package cn.itcast;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        Test.showReversed(singleLinkedList.getHeadNode());
    }

    //1) 求单链表中有效节点的个数
    public static int validNums(SingleLinkedList singleLinkedList) {

        if (singleLinkedList == null) {
            System.out.println("输入参数有误，重新输入");
            return 0;
        }
        //定义一个临时节点
        HeroNode tempNode = new HeroNode();
        //临时节点指向单向链表的头节点
        tempNode = singleLinkedList.getHeadNode();
        //若头节点的next为空，则返回
        if (tempNode.next == null) {
            return 0;
        }
        //定义有效节点个数
        int sum = 0;
        while (true) {
            if (tempNode.next == null) {
                break;
            }
            tempNode = tempNode.next;
            sum++;
        }
        return sum;
    }

    //2) 查找单链表中的倒数第 k 个结点 【新浪面试题】
    public static HeroNode findNodeByNum(SingleLinkedList singleLinkedList, int num) {
        HeroNode headNode = singleLinkedList.getHeadNode();
        //有效节点个数
        int nums = Test.validNums(singleLinkedList);
        if (singleLinkedList == null || num < 0 || num > nums) {
            System.out.println("输入参数有误，重新输入");
            return null;
        }
        if (headNode.next == null) {
            System.out.println("链表为空，无法找到");
            return null;
        }
        //遍历nums-num次
        HeroNode tempNode = new HeroNode();
        tempNode = headNode;
        for (int i = 0; i < nums - num; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.next;
    }

    //    3) 单链表的反转【腾讯面试题，有点难度】
    public static void reverseLinkedList(HeroNode oldHeadNode){

        if(oldHeadNode.next == null || oldHeadNode.next.next == null){
            System.out.println("输入有误，无法转换");
            return;
        }
        HeroNode curNode = oldHeadNode.next;
        HeroNode nextNode = null;
        HeroNode newHeadNode = new HeroNode(0,"","");
        while(curNode != null){
            nextNode = curNode.next;
            curNode.next = newHeadNode.next;
            newHeadNode.next = curNode;
            curNode = nextNode;
        }
        oldHeadNode.next = newHeadNode.next;
    }

    public static void showReversed(HeroNode headNode){
        if(headNode.next == null){
            System.out.println("链表为空，无法显示");
            return;
        }
        Stack<HeroNode> nodeStack = new Stack<>();
        HeroNode tempNode = headNode.next;
        while(tempNode != null){
            nodeStack.push(tempNode);
            tempNode = tempNode.next;
        }
        while(nodeStack.size() > 0){
            System.out.println(nodeStack.pop());
        }
    }

}


