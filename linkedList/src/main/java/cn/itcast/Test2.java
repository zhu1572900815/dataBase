package cn.itcast;

public class Test2 {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero7 = new HeroNode2(7, "吴用", "智多星");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();


        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero7);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero2);

        doubleLinkedList.showSingleLinkedList();
        doubleLinkedList.delHeroNode(3);
        doubleLinkedList.showSingleLinkedList();

    }
}
