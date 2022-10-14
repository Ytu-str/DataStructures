package com.ytustr.linkedlist;

/**
 * 双向链表
 *
 * @author Ytu-str
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        DoubleLinkedList singleLinkedList = new DoubleLinkedList();
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.list();
    }

}
class DoubleLinkedList{
    /**
     * 先初始化一个头节点
     */
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead(){
        return head;
    }

    /**
     * 添加到最后
     */
    public void add(HeroNode2 node){
        //为什么需要辅助变量，因为head是不能动的
        HeroNode2 temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //退出循环时，temp指向链表最后
        temp.next = node;
        node.pre = temp;
    }

    public void addByOrder(HeroNode2 node){
        //为什么需要辅助变量，因为head是不能动的
        HeroNode2 temp = head;
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
           if (temp.next != null){
               temp.next.pre = node;
               node.next = temp.next;
           }
           temp.next = node;
           node.pre = temp;
        }
    }

    /**
     * 修改
     */
    public void update(HeroNode2 newHeroNode){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head;
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
     * 删除节点:双向链表可以直接找到要删除的节点。可以自我删除
     */
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //如果删除的是最后一个节点，这里有问题，，如果是最后一个节点就不需要执行这句话
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("不存在的节点......");
        }
    }

    /**
     * 遍历双向链表
     */
    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}
class HeroNode2{

    public int no;

    public String name;

    public String nickName;

    public HeroNode2 next;

    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName){
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
