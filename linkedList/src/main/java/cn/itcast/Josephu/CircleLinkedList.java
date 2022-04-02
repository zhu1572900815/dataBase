package cn.itcast.Josephu;

public class CircleLinkedList {

    private Boy first = null;

    public Boy getFirst() {
        return first;
    }

    public void  addBoys(int nums){
        if(nums < 0 || nums == 1){
            System.out.println("输入人数有错，重新输入");
            return;
        }
        Boy curBoy = null; // 辅助指针，帮助构建环形链表
        //创建其他节点
        for(int i = 1; i <= nums; i++){
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                boy.setNextBoy(first);
                curBoy = first;
            }else{
                curBoy.setNextBoy(boy);
                boy.setNextBoy(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy(){
        if(first == null){
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while(true){
            System.out.println("编号为" + curBoy.getNum() + "的男孩");
            if(curBoy.getNextBoy() == first){
                break;
            }
            curBoy = curBoy.getNextBoy();

        }
    }

    /**
     *
     * @param startNum 从第startNum个小孩开始玩
     * @param countNum 数countNum个数
     * @param nums 总共有nums个小孩玩
     */
    public void game(int startNum,int countNum,int nums){
        if(first == null || startNum < 1 || startNum > countNum){
            System.out.println("输入有误");
            return;
        }

        Boy helper = first;
        while(true){
            if(helper.getNextBoy() == first){
                break;
            }
            helper = helper.getNextBoy();
        }

        for(int i = 0; i < startNum - 1; i++){
            first = first.getNextBoy();
            helper = helper.getNextBoy();
        }

        while(true){
            if(first == helper){
                break;
            }
            for(int i = 0; i < countNum - 1; i++){
                first = first.getNextBoy();
                helper = helper.getNextBoy();
            }
            System.out.println("第" + first.getNum() + "小孩出圈");
            first = first.getNextBoy();
            helper.setNextBoy(first);
        }
        System.out.println("幸运人是" + first.getNum());
    }
}
