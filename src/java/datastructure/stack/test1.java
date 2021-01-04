package java.datastructure.stack;

import java.util.Scanner;

/**
 * @author: LinKai
 * @time: 2021/1/4-20:57
 */

public class test1 {
    public static boolean isok(String s) {
        MyStack<Character> brackets = new MyArrayStack<Character>(20);
        char[] c = s.toCharArray();
        Character top;
        for (char x : c) {
            switch (x) {
                case '{':
                case '(':
                case '[':
                    brackets.push(x);
                    break;
                case '}':
                    top=brackets.pop();
                    if (top==null) return false;
                    if(top=='{'){
                        break;
                    }else{
                        return false;
                    }
                case ')':
                    top=brackets.pop();
                    if (top==null) return false;
                    if(top==')'){
                        break;
                    }else{
                        return false;
                    }
                case ']':
                    top=brackets.pop();
                    if (top==null) return false;
                    if(top==']'){
                        break;
                    }else{
                        return false;
                    }
                default:
                    break;
            }
        }
        boolean empty = brackets.isEmpty();
        return empty;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s=scanner.next();
            System.out.println("s的匹配结果："+isok(s));
        }
    }
}
