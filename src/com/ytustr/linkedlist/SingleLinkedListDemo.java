package com.ytustr.linkedlist;

import java.util.Stack;

/**
 * 单链表
 *
 * @author Ytu-str
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.list();
        System.out.println(singleLinkedList.getLength());
    }
}
class SingleLinkedList{
    /**
     * 先初始化一个头节点
     */
    private HeroNode head = new HeroNode(0,"","");

    /**
     * 当不考虑编号顺序时，找到当前链表的最后一个节点，指向新节点
     * @param node
     */
    public void add(HeroNode node){
        //为什么需要辅助变量，因为head是不能动的
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //退出循环时，temp指向链表最后
        temp.next = node;
    }

    public void addByOrder(HeroNode node){
        //为什么需要辅助变量，因为head是不能动的
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            //位置找到，在temp的后面插入
            if (temp.next.no > node.no){
                break;
            }
            if (temp.next.no == head.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("数据编号重复......");
        }else {
            //插入到链表
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 修改 根据no修改
     */
    public void update(HeroNode newHeroNode){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        //是否找到节点
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.println("没有找到......");
        }
    }

    /**
     * 删除节点：需要找到要删除节点的前一个节点
     */
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("不存在的节点......");
        }
    }

    public int getLength(){
        if (head.next ==null){
            return 0;
        }
        HeroNode temp = head;
        int length = 0;
        while (true){
            if (temp.next == null){
                break;
            }
            length++;
            temp = temp.next;
        }
        return length;
    }


    /**
     * 查找单链表中倒数第K个节点
     *
     * 编写一个方法，接收head节点，index
     * index表示倒数第几个
     * 先把链表从头到尾遍历，得到链表的长度
     * 的到size后，再次遍历（size-index)次
     */
    public HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null){
            return null;
        }
        int size = getLength() - index;
        if (size <= 0 || index > size){
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 反转单链表
     * @param head
     */
    public void reverseList(HeroNode head){
        if (head.next == null || head.next.next == null){
            return;
        }
        HeroNode temp = head.next;
        HeroNode next = null;
        HeroNode newHeadNode = new HeroNode(0,"","");
        while (temp != null){
            next = temp.next;
            temp.next = newHeadNode.next;
            newHeadNode.next = temp;
            temp = next;
        }
        head.next = newHeadNode.next;
    }

    /**
     * 使用栈进行逆序遍历
     */
    public void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    /**
     * 遍历链表
     */
    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

class HeroNode{

    public int no;

    public String name;

    public String nickName;

    public HeroNode next;

    public HeroNode(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
