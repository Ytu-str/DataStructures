package com.ytustr.tree;

/**
 * 二叉树遍历
 * @author Ytu-str
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "兔兔");
        HeroNode node2 = new HeroNode(2, "狗狗");
        HeroNode node3 = new HeroNode(3, "猫猫");
        HeroNode node4 = new HeroNode(4, "nice");
        HeroNode node5 = new HeroNode(5, "5");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.midOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();
        HeroNode heroNode = binaryTree.perOrderSearch(4);
        System.out.println(heroNode);
    }
}
class BinaryTree{

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    /**
     * 前序遍历
     */
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }
    }

    public void midOrder(){
        if (this.root != null){
            this.root.midOrder();
        }
    }

    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }
    }
    public HeroNode perOrderSearch(int no){
        if (root == null){
            return null;
        }else {
            return root.perOrderSearch(no);
        }
    }
}
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    public HeroNode(int no, String name){
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    public void midOrder(){
        if (this.left != null){
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.midOrder();
        }
    }

    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode perOrderSearch(int no){
        if (this.no == no){
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.perOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.perOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode midOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.midOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            resNode = this.right.midOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if (this.no == no){
            return this;
        }
        return resNode;
    }

    public void delNode(int no){
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.delNode(no);
        }
        if (this.right != null){
            this.right.delNode(no);
        }

    }

}
