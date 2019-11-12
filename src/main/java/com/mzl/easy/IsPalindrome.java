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

//        boolean b1 = myDemo1(-121);
//        System.out.println(b1);

        boolean b1 = myDemo2(123454321);
        System.out.println(b1);

//        boolean b1 = otherDemo1(123454321);
//        System.out.println(b1);
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
     * 思路等同于otherDemo
     * @param num
     * @return
     */
    private static boolean myDemo2(int num) {
        if(num < 0){
            return false;
        }

        String str = String.valueOf(num);
        int start = 0;
        int end = str.length() - 1;

        while (start < end){
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    /**
     *
     * @param x
     * @return
     */
    public static boolean otherDemo (int x) {

        //边界判断，负数肯定不是回文数
        if (x < 0) return false;

        //判断整数位数
        int div = 1;

        while (x / div >= 10) div *= 10;
        while (x > 0){
            int left = x / div; //算出左第一个数
            int right = x % 10; //算出右第一个数

            if(left != right) return false;

            //因为左边第一个数和右边第一个数已对比完，所起去掉，获取中间的数
            x = x % div / 10;
            //因为移除了前后两个数，所以div除100
            div /= 100;
        }
        return true;
    }

    /**
     * 按照第二个想法，为了避免数字反转可能导致的溢出问题，为什么不考虑只反转 int 数字的一半？毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
     * 例如，输入 1221，我们可以将数字 “1221” 的后半部分从 “21” 反转为 “12”，并将其与前半部分 “12” 进行比较，因为二者相同，我们得知数字 1221 是回文。
     * 让我们看看如何将这个想法转化为一个算法。
     *
     * @param x
     * @return
     */
    private static boolean otherDemo1 (int x) {
        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
