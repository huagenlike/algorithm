package com.mzl.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * @ClassName IsValid
 * @Description: 有效的括号
 * @Author may
 * @Date 2019/11/14 17:19
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 * 示例 5:
 * 输入: "()(([[{}{}([{}])]]))"
 * 输出: true
 */
public class IsValid {
    public static void main(String[] args) {
        boolean b = myDemo1("()()({{[[][]{}{([])}]}})");
//        boolean b = myDemo("{()}");
//        boolean b = myDemo("()[]{}");
        System.out.println(b);
    }

    /**
     * 判断是否为空
     * stack.empty()
     * 取栈顶值（不出栈）
     * stack.peek()
     * 进栈
     * stack.push(Object);
     * 出栈
     * stack.pop();
     * @param s
     * @return
     */
    public static boolean myDemo(String s) {
        if(s.length() == 0) return true;
        Stack stack=new Stack();
        stack.push(s.charAt(0));
        for (int i  = 1; i < s.length(); i++) {
            if(!stack.empty() && Objects.equals(stack.peek(), getValue(s.charAt(i)))){
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.empty() ? true : false;
    }

    public static boolean myDemo1(String s) {

        Stack<Character> stack = new Stack<Character>();

        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        for (int i  = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                //堆栈的顶部。如果堆栈为空,设置一个虚拟的“#”
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if(topElement != map.get(c)) return false;
            }else{
                stack.push(c);
            }

        }
        return stack.empty() ? true : false;
    }

    public static char getValue(char str){
        Map<Character, Character> map = new HashMap<>();
        //其实只要判断后面的括号
//        map.put('{', '}');
//        map.put('(', ')');
//        map.put('[', ']');
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        return map.get(str);
    }
}
