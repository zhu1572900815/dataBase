package cn.itcast;

public class SingleLinkedList {

    private  HeroNode headNode = new HeroNode(0," "," ");

    public HeroNode getHeadNode(){
        return headNode;
    }
    /**
     * 给单向列表添加节点，不考虑顺序
     * @param heroNode
     */
    public  void add(HeroNode heroNode){
        //添加节点一般找到next为null的节点，因此需要遍历
        HeroNode temp = headNode;
        //遍历，找到最后一个节点，也就是此节点的next为null
        while(true){
            //1、首先判断temp的next是否为null，若为null则直接break；否则节点后移
            if(temp.next == null){
                break;
            }else{
                temp = temp.next;
            }
        }
        temp.next = heroNode;
    }

    /**
     * 按照顺序添加节点
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode){
        //1、通过遍历链表，找到比想要加入的链表的no值大于的链表的前一个链表
        HeroNode tempHeroNode = headNode;
        boolean flag = false;
        while(true) {
            if(tempHeroNode.next == null){
                break;
            }
            if(tempHeroNode.next.no > heroNode.no){
                break;
            }else if(tempHeroNode.next.no == heroNode.no){
                flag = true;
                break;
            }
            tempHeroNode = tempHeroNode.next;
        }
        if(flag){
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        }else{
            heroNode.next = tempHeroNode.next;
            tempHeroNode.next = heroNode;
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
        HeroNode tempNode = headNode;
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
    public void updateSingleLinkedList(HeroNode heroNode){
        //1、若链表为空则不能修改链表中的节点
        if(headNode.next == null){
            System.out.println("链表为空，无法修改");
            return;
        }
        //2、遍历链表，寻找heroNode节点，若找到则修改信息，若没有找到则输出提示信息
        HeroNode tempHeroNode = headNode;
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

    public void delNode(int no){
        if(headNode.next == null){
            System.out.println("链表为空，无法删除该节点");
            return;
        }
        //1、通过遍历找到此节点
        boolean flag = false;
        HeroNode tempHeroNode = headNode;
        while(true){
            if(tempHeroNode.next.no == no){
                flag = true;
                break;
            }
            tempHeroNode = tempHeroNode.next;
            if(tempHeroNode.next == null){
                break;
            }
        }
        if(flag){
            tempHeroNode.next = tempHeroNode.next.next;
        }else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

    }
}
