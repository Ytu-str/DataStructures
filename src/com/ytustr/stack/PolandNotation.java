package com.ytustr.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 逆波兰表达式
 * @author Ytu-str
 */
public class PolandNotation {
    public static void main(String[] args) {
//        String suffixExpression = "3 4 + 5 * 6 -";
//        List<String> listString = getListString(suffixExpression);
//        int calculate = calculate(listString);
//        System.out.println(calculate);
        String expression = "1+((2+3)*4)-5";
        List<String> list = toInfixExpressionList(expression);
        System.out.println(list);
        List<String> list1 = parseSuffixExpressionList(list);
        System.out.println(list1);
        int calculate = calculate(list1);
        System.out.println(calculate);
    }

    public static List<String> parseSuffixExpressionList(List<String> list){
        Stack<String> stack1 = new Stack<>();
        List<String> stack2 = new ArrayList<>();
        for (String s : list) {
            //操作数
            if (s.matches("\\d+")){
                stack2.add(s);
            }else if (s.equals("(")){
                stack1.add(s);
            } else if (stack1.isEmpty() || stack1.peek().equals("(")){
                stack1.push(s);
            }else if (s.equals(")")){
                while (!stack1.peek().equals("(")){
                    stack2.add(stack1.pop());
                }
                stack1.pop();
            } else {
                while (stack1.size() != 0 && priority(s.charAt(0)) >= priority(stack1.peek().charAt(0))){
                    stack2.add(stack1.pop());
                }
                stack1.push(s);
            }
        }
        while (!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        return stack2;
    }

    public static int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else{
            return -1;
        }
    }

    public static List<String> toInfixExpressionList(String s){
        List<String> list = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        do {
            //非数字
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                list.add("" + c);
                i++;
            }else {
                //如果是数字，考虑多位数问题
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57){
                    str += c;
                    i++;
                }
                list.add(str);
            }
        }while (i < s.length());
        return list;
    }

    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        return Arrays.stream(split).collect(Collectors.toList());
    }

    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            //匹配的是多位数
            if (s.matches("\\d+")){
                stack.push(s);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (s.equals("+")){
                    res = num1 + num2;
                }else if (s.equals("-")){
                    res = num1 - num2;
                }else if (s.equals("*")){
                    res  = num1 * num2;
                }else if (s.equals("/")){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("错误");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
