package com.ytustr.stack;

/**
 * 链表栈
 * @author Ytu-str
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        linkedListStack.push(node1);
        linkedListStack.push(node2);
        linkedListStack.push(node3);
        linkedListStack.push(node4);
        linkedListStack.list();
        Node pop = linkedListStack.pop();
        System.out.println("出栈："+pop.value);
        linkedListStack.list();
        Node pop2 = linkedListStack.pop();
        System.out.println("出栈："+pop2.value);
        linkedListStack.list();
    }
}

class LinkedListStack{

    private Node head = new Node(-1);

    private Node temp = head;

    public boolean isEmpty(){
        return head.next == null;
    }

    public void push(Node node){
        while (true){
            if (temp.next == null){
                break;
            }
        }
        temp.next = node;
        node.pre = temp;
        temp = temp.next;
    }

    public Node pop(){
        if (temp.pre == head){
            throw new RuntimeException("栈空");
        }
        Node value = temp;
        temp = temp.pre;
        temp.next = null;
        return value;
    }


    public void list(){
        if (isEmpty()){
            return;
        }
        Node cur = temp;
        while (cur.pre != null){
            System.out.println(cur.value);
            cur = cur.pre;
        }
    }

}

class Node{
    public int value;
    public Node next;
    public Node pre;

    public Node(int value){
        this.value = value;
    }
}