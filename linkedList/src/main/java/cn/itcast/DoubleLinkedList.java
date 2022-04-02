package cn.itcast;

public class DoubleLinkedList {
    private HeroNode2 headNode = new HeroNode2(0," "," ");

    public HeroNode2 getHeadNode(){
        return headNode;
    }

    /**
     * 按照顺序添加节点
     * @param heroNode
     */
    public void addByOrder(HeroNode2 heroNode){
        //1、通过遍历链表，找到比想要加入的链表的no值大于的链表的前一个链表
        HeroNode2 tempHeroNode = headNode;
        boolean flag = false;
        while(true) {
            if(tempHeroNode.next == null){
                break;
            }
            tempHeroNode = tempHeroNode.next;
            if(tempHeroNode.no < heroNode.no){
                break;
            }else{
                if(tempHeroNode.no == heroNode.no){
                    flag = true;
                    break;
                }
            }
        }
        if(flag){
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        }else{
            if(tempHeroNode.next == null){
                tempHeroNode.next = heroNode;
                heroNode.pre = tempHeroNode;
            }else{
                heroNode.next = tempHeroNode.next;
                heroNode.pre = tempHeroNode;
                tempHeroNode.next.pre = heroNode;
                tempHeroNode.next = heroNode;
            }
        }
    }

    /**
     * 显示单链表
     */
    public void showSingleLinkedList(){
        //1、若头节点的next为null，则表示此单链表为空
        if(headNode.next == null){
            System.out.println("链表为空，没有数据展示");
            return;
        }
        //2、头节点的next不为空，需要遍历输出数据
        HeroNode2 tempNode = headNode;
        while(true){
            System.out.println(tempNode.next);
            tempNode = tempNode.next;
            if(tempNode.next == null){
                break;
            }
        }
    }

    /**
     * 修改节点
     * @param heroNode
     */
    public void updateSingleLinkedList(HeroNode2 heroNode){
        //1、若链表为空则不能修改链表中的节点
        if(headNode.next == null){
            System.out.println("链表为空，无法修改");
            return;
        }
        //2、遍历链表，寻找heroNode节点，若找到则修改信息，若没有找到则输出提示信息
        HeroNode2 tempHeroNode = headNode;
        boolean flag = false;
        while(true){
            if(tempHeroNode == null){
                break;
            }
            //说明找到了想要的节点
            if(tempHeroNode.no == heroNode.no){
                flag = true;
                break;
            }
            tempHeroNode = tempHeroNode.next;
        }
        //3、找到节点
        if(flag){
            tempHeroNode.name = heroNode.name;
            tempHeroNode.nickname = heroNode.nickname;
        }else { //没有找到
            System.out.printf("没有找到编号 %d 的节点，不能修改\n", heroNode.no);
        }
    }

    public void delHeroNode(int num){
        if(num < 0){
            System.out.println("输入有误，重新输入");
            return;
        }
        if(headNode.next == null){
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        HeroNode2 tempNode = headNode.next;
        while(true){
            if(tempNode.no == num){
                flag = true;
                break;
            }
            tempNode = tempNode.next;
            if(tempNode == null){
                break;
            }
        }

        if(flag){
            tempNode.pre.next = tempNode.next;
            // 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if (tempNode.next != null) {
                tempNode.next.pre = tempNode.pre;
            }
        }else{
            System.out.println("没有找到编号为" + num + "的节点，无法删除");
        }
    }
}

class HeroNode2 {

    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public HeroNode2() {
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
