package com.ytustr.queue;

/**
 * 数组队列
 *
 * @author Ytu-str
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {

    }

}
class ArrayQueue{
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

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        //队列第一个数据的前一个位置
        this.front = -1;
        //队列尾最后一个数据的位置
        this.rear = -1;
        this.arr = new int[maxSize];
    }

    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 判断队列是否满了
     * @return
     */
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public void addQueue(int data){
        if (isFull()){
            System.out.println("队列满了，不能添加数据");
            return;
        }
        arr[++rear] = data;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空......");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空......");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d\t",arr[i]);
        }
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空......");
        }
        return arr[front+1];
    }
}
