package com.mzl.easy;

import java.math.BigDecimal;

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
    //private static int num = 123;

    public static void main(String[] args) {
//        Integer integer = otherDemo();
//        System.out.println(integer);
        Integer integer1 = myDemo(123);

        System.out.println(integer1);
    }

    /**
     * 本题如果不考虑溢出问题，是非常简单的。解决溢出问题有两个思路，第一个思路是通过字符串转换加try catch的方式来解决，第二个思路就是通过数学计算来解决。
     * 由于字符串转换的效率较低且使用较多库函数，所以解题方案不考虑该方法，而是通过数学计算来解决。
     * TODO 很不幸的是第一想到的就是字符串，而且溢出使用try catch还是网上搜了资料后尝试着加的，用来解决int溢出
     * @param num
     * @return
     */
    public static Integer myDemo(int num){

        long integer = 0;
        boolean isTrue = false;

        try{
            if (num < 0) {
                isTrue = true;
                //取绝对值
                num = Math.abs(num);
            }
            String s = Integer.valueOf(num).toString();

            //通过StringBuilder的reverse()方法取反，如果是负数，则调用insert()在最前面插入-
            String data = isTrue == true ? new StringBuilder(s).reverse().insert(0, "-").toString() : new StringBuilder(s).reverse().toString() ;
            integer = Integer.valueOf(data);
        }catch (Exception e){
            e.printStackTrace();
        }

        return integer < Integer.MIN_VALUE || integer > Integer.MAX_VALUE ? 0 : (int)integer;
    }

    /**
     * 解题思路
     * 如果这里是123为例，分别对123求余和整除。123 % 10 = 3， 123 / 10 = 12。
     * 溢出可以通过try catch方式处理，或者return 0。
     * @return
     */
    public static Integer otherDemo(int num) {
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
