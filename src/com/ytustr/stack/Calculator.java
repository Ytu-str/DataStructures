package com.ytustr.stack;

/**
 * 栈实现综合计算器
 * @author Ytu-str
 */
public class Calculator {

    public static void main(String[] args) {
        String expression = "30+2*6-2";
        ArrayStack2 numberStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        char ch = 0;
        int res = 0;
        int oper = ' ';
        String keepNum = "";
        while (true){
            ch = expression.substring(index,index+1).charAt(0);
            if (operStack.isOper(ch)){
                if (!operStack.isEmpty()){
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        oper = operStack.pop();
                        res = numberStack.cal(num1,num2,oper);
                        numberStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }else {
                    operStack.push(ch);
                }
            }else {
//                numberStack.push(ch - 48);
//                numberStack.push(ch - '0');
                keepNum += ch;
                if (index == expression.length() - 1){
                    numberStack.push(Integer.parseInt(keepNum));
                }else {
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        //如果后一位是运算符
                        numberStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()){
                break;
            }
        }
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            oper = operStack.pop();
            res = numberStack.cal(num1,num2,oper);
            numberStack.push(res);
        }
        System.out.printf("表达式结果：%d",numberStack.pop());
    }

}
class ArrayStack2{
    private int maxSize;
    private int[] stack;
    /**
     * 栈底
     */
    private int top = -1;

    public ArrayStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public int peek(){
        return stack[top];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈满了");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list(){
        if (isEmpty()){
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.println(stack[i]);
        }
    }

    /**
     * 返回运算符的优先级，优先级使用数字表示，数字越大，优先级越高
     */
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else{
            return -1;
        }
    }

    /**
     * 判断是不是一个运算符
     */
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     */
    public int cal(int num1, int num2, int oper){
        //存放计算结果
        int res = 0;
        switch (oper){
            case '+' :
                res = num2 + num1;
                break;
            case '-' :
                //注意顺序
                res = num2 - num1;
                break;
            case '*' :
                res = num2 * num1;
                break;
            case '/' :
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
