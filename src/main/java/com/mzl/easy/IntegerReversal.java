package com.mzl.easy;

/**
 * @ClassName IntegerReversal
 * @Description: 整数反转
 * @Author may
 * @Date 2019/11/7 15:58
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 *  输入: 123
 *  输出: 321
 *
 * 示例 2:
 *  输入: -123
 *  输出: -321
 *
 * 示例 3:
 *  输入: 120
 *  输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class IntegerReversal {

    //假定输入是32位的整数，则反转1000000003溢出
    private static int num = 1000000003;

    public static void main(String[] args) {
        Integer integer = otherDemo();
        System.out.println(integer);
    }

    /**
     * 解题思路
     * 如果这里是123为例，分别对123求余和整除。123 % 10 = 3， 123 / 10 = 12。
     * 溢出可以通过try catch方式处理，或者return 0。
     * @return
     */
    public static Integer otherDemo() {
        //用long类型判断溢出
        long rs = 0;
        //逆序，正负通吃，不用单独考虑负值
        while(num != 0){
            rs = rs * 10 + num % 10;
            num /= 10;
        }
        ////超了最大值低于最小值就返回0
        return (rs<Integer.MIN_VALUE || rs>Integer.MAX_VALUE) ? 0:(int)rs;
    }
}
