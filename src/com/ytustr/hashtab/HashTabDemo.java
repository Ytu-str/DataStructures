package com.ytustr.hashtab;

/**
 * @author Ytu-str
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        Emp emp = new Emp(1, "11");
        Emp emp2 = new Emp(3, "31");
        hashTab.add(emp);
        hashTab.add(emp2);
        hashTab.list();
        Emp emp1 = hashTab.get(1);
        System.out.println(emp1.toString());
    }
}
class HashTab{

    private EmpLinkedList[] empLinkedListArray;

    private int size;

    public HashTab(int size){
        this.empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
        this.size = size;
    }
    public void add(Emp emp){
        int i = hashFun(emp.id);
        empLinkedListArray[i].add(emp);
    }

    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list();
        }
    }

    public Emp get(int id){
        int i = hashFun(id);
        return empLinkedListArray[i].findEmpById(id);
    }

    public int hashFun(int id){
        return id % size;
    }
}
class EmpLinkedList{
    private Emp head;
    public void add(Emp emp){
        if (head == null){
            head =  emp;
            return;
        }else {
            Emp temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = emp;
        }
    }
    public void list(){
        if (head == null){
            return;
        }
        Emp temp = head;
        while (temp != null){
            System.out.println("id:"+temp.id+"name:"+temp.name);
            temp = temp.next;
        }
    }
    public Emp findEmpById(int id){
        if (head == null){
            return null;
        }
        Emp temp = head;
        while (true){
            if (temp.id == id){
                break;
            }
            if (temp.next == null){
                temp = null;
                break;
            }
            temp = temp.next;
        }
        return temp;
    }
}
class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
