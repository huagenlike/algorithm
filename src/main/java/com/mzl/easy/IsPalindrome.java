package com.mzl.easy;

import java.util.Objects;

/**
 * @ClassName IsPalindrome
 * @Description: 回文数
 * @Author may
 * @Date 2019/11/11 15:07
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class IsPalindrome {

    public static void main(String[] args) {
//        boolean b = myDemo(121);
//        System.out.println(b);

        boolean b1 = myDemo1(-121);
        System.out.println(b1);
    }

    /**
     * int使用 + 连接 字符串，会重新生成一个新的字符串
     * 这需要额外的非常量空间来创建问题描述中所不允许的字符串。
     */
    private static boolean myDemo(int num){
        StringBuilder reverse = new StringBuilder(num + "").reverse();
        return Objects.equals(num + "", reverse.toString());
    }

    /**
     * 第二个想法，使用整数反转的方式，排除为负数的情况，因为负数的回文数肯定是false
     * 但是，如果反转后的数字大于 int.MAX，我们将遇到整数溢出问题。
     * @param num
     * @return
     */
    private static boolean myDemo1(int num){
        if(num < 0){
            return false;
        }

        int pram = num;
        long rs = 0;

        while (num != 0) {
            rs = rs * 10 + num % 10;
            num /= 10;
        }
        return (int)rs == pram;
    }

    /**
     * 按照第二个想法，为了避免数字反转可能导致的溢出问题，为什么不考虑只反转 int 数字的一半？毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
     * 例如，输入 1221，我们可以将数字 “1221” 的后半部分从 “21” 反转为 “12”，并将其与前半部分 “12” 进行比较，因为二者相同，我们得知数字 1221 是回文。
     * 让我们看看如何将这个想法转化为一个算法。
     *
     * @param num
     * @return
     */
    private static boolean otherDemo (int num) {
        if (num < 0) {
            return false;
        }

        return false;
    }
}
