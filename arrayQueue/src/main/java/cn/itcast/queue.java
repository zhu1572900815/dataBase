package cn.itcast;

public class queue {
    private int maxSize;
    private int[] queueArray;
    private int rear = 0;
    private int front = 0;

    /**
     * queue对象的构造函数，传入的参数表示该队列的大小，注意队列的实际大小为maxSize - 1
     * @param maxSize
     */
    public queue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
    }

    /**
     * 判断该队列是否满，如果是满的，则返回true；否则返回false
     * @return
     */
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断该队列是否为空，如果是空的，则返回true；否则返回false
     * @return
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 计算出该队列有效数据的个数
     * @return
     */
    public int validNum(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有有效数据");
        }
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 将数据加入到队列中
     * @param num
     */
    public void add(int num){
        if(isFull()){
            System.out.println("队列已满，无法添加数据");
            return;
        }
        queueArray[rear] = num;
        //对rear进行取模，
        rear = (rear + 1) % maxSize;
    }

    /**
     * 从队列中取出数据
     * @return
     */
    public int get(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        int tempNum = queueArray[front];
        front = (front + 1) % maxSize;
        return tempNum;
    }

    /**
     * 遍历队列
     */
    public void show(){
        if(isEmpty()){
            System.out.println("队列为空，不能遍历队列");
            return;
        }
        int sumNum = validNum();
        for(int i = front; i < front + sumNum; i++){
            System.out.println("queueArr["+ i % maxSize +"] = " + queueArray[i % maxSize]);
        }
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("空队列,无法查看");
        }
        return queueArray[front];
    }
}
