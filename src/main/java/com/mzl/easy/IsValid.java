package com.mzl.easy;

import java.util.HashMap;
import java.util.Map;

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
 */
public class IsValid {
    public static void main(String[] args) {
//        boolean b = myDemo("})({");
//        boolean b = myDemo("{[)}");
        boolean b = myDemo("()[]{}");
        System.out.println(b);
    }

    public static boolean myDemo(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char preChar = s.charAt(start);
            if(preChar == ')' || preChar == '}' || preChar == ']' || preChar != getValue(s.charAt(end))) return false;
            start++;
            end--;
        }
        return true;
    }

    public static char getValue(char str){
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        return map.get(str);
    }
}
