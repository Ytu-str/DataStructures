package com.ytustr.tree.threadedbinarytree;

/**
 * 线索化二叉树
 * @author Ytu-str
 */
public class ThreadedBinaryTree {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);
        binaryTree.threadedNodes();
        HeroNode left = node5.getLeft();
//        System.out.println(left);
//        System.out.println(node5.getRight());
        binaryTree.threadedList();
    }
}

/**
 * 实现了线索化功能的二叉树
 */
class BinaryTree{

    private HeroNode root;

    /**
     * 为了实现线索化，需要创建指向当前节点的前驱节点的指针
     * 在递归时，总是保留前节点
     */
    private HeroNode per = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 遍历线索化二叉树的方法
     */
    public void threadedList(){
        HeroNode temp = root;
        while (temp != null){
            while (temp.getLeftType() == 0){
                temp = temp.getLeft();
            }
            System.out.println(temp);
            while (temp.getRightType() == 1){
                //获取当前节点的后继节点
                temp = temp.getRight();
                System.out.println(temp);
            }
            //替换这个遍历的节点
            temp = temp.getRight();
        }
    }

    public void threadedNodes(){
        threadedNodes(root);
    }

    /**
     *
     * @param node 当前需要线索化的节点
     */
    public void threadedNodes(HeroNode node){
        if (node == null){
            return;
        }
        //先线索化左子树
        threadedNodes(node.getLeft());
        //线索化当前节点
        if (node.getLeft() == null){
            node.setLeft(per);
            //修改当前节点左指针的类型
            node.setLeftType(1);
        }
        //处理后继节点
        if (per != null && per.getRight() == null){
            //让前驱节点的右指针指向当前节点
            per.setRight(node);
            per.setRightType(1);
        }
        //每处理一个节点后，让当前节点是下一个节点的前驱节点
        per = node;
        //线索化右子树
        threadedNodes(node.getRight());
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
    /**
     * 如果0表示指向左子树，1指向前驱节点
     */
    private int leftType;
    /**
     * 0:指向右子树。1：指向后继节点
     */
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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
