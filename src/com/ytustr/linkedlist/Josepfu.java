package com.ytustr.linkedlist;

/**
 * 约瑟夫问题
 * 单环形列表
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(10);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,2,5);
    }
}
class CircleSingleLinkedList{

    private Boy first = new Boy(-1);

    public void addBoy(int nums){
        if (nums < 1){
            return;
        }
        //辅助变量，帮助构建环形链表
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy(){
        if (first == null){
            System.out.println("空链表");
            return;
        }
        Boy cur = first;
        while (true){
            System.out.println(cur.getNo());
            if (cur.getNext() == first) {
                return;
            }
            cur = cur.getNext();
        }
    }

    /**
     * 根据用户输入计算出圈顺序
     * @param startNo 从第几个开始数
     * @param countNum 数几个
     * @param nums 最初多少个
     */
    public void countBoy(int startNo, int countNum, int nums){
        addBoy(nums);
        if (first == null || startNo < 1 || startNo > nums){
            return;
        }
        Boy helper = first;
        //将helper指向环形链表的最后节点
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //报数前，将first和helper移动k-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //报数，first和helper移动m-1次,然后出圈
        while (true){
            //说明只有一个了
            if (helper == first){
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时，first就是要出圈的
            System.out.printf("出圈：%d",first.getNo());
            helper.setNext(first.getNext());
            first = first.getNext();
        }
        System.out.printf("最后的编号：%d",first.getNo());
    }
}

class Boy{

    private int no;

    private Boy next;

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}