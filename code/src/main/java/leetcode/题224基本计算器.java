package leetcode;

import java.util.Stack;
/**
 * @author yang
 * 2021年07月20日 22:10:00
 */
public class 题224基本计算器 {
    public static void main(String[] args) {

        String s= "2-1+2";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        String S = s;
        return calcu(S);
    }
    //index全局变量,递归时方便使用
    private static int index = 0;
    public static int calcu(String s){
        if (s == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char oper ='+';
        while (index < s.length()) {
            Character c = s.charAt(index++);

            if (Character.isDigit(c)) {
                num = num*10+(c-'0');
            }
            if (c == '(') {
                num = calculate(s);
            }

            //如果不是,就把符号后边的数字处理后加入栈中
            if((!Character.isDigit(c) && c != ' ') || index == s.length()){
                int tmp;
                switch(oper){
                    case '+' : stack.push(num);
                        break;
                    case '-' : stack.push(-num);
                        break;
                    case '*' : tmp = stack.pop() * num;
                        stack.push(tmp);
                        break;
                    case '/' : tmp = stack.pop() / num;
                        stack.push(tmp);
                        break;
                }
                //重新归0,操作符设置为c;
                num = 0;
                oper = c;
            }
            //遇到右括号就停止计算
            if(c == ')'){
                break;
            }
        }
        int  sum = 0;
        //计算总数并返回
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}
