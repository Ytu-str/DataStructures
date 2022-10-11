package com.ytustr.queue;

/**
 * 环形数组队列
 *
 * @author Ytu-str
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //有效数量为3，有一个预留空间
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
    }
}
class CircleArrayQueue {
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 数据
     */
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        //队列第一个数据的位置
        this.front = 0;
        //队列尾最后一个数据的后一个位置，预留空间
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断队列是否满了
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void addQueue(int data) {
        if (isFull()) {
            System.out.println("队列满了，不能添加数据");
            return;
        }
        //直接加入数据
        arr[rear] = data;
        //将rear后移
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空......");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front的值保留到一个临时变量
        //2.将front后移,考虑取模
        //3.将临时变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空......");
            return;
        }
        //从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("%d\t", arr[i % maxSize]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空......");
        }
        return arr[front];
    }

    //求出当前队列有效数据个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }
}