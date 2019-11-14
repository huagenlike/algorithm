package com.mzl.easy;

import java.util.Date;
import java.util.Objects;

/**
 * @ClassName LongestCommonPrefix
 * @Description: 最长公共前缀
 * @Author may
 * @Date 2019/11/12 16:50
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 *
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        long startTime = new Date().getTime();
//        String[] strs = {"flower","flow","flight"};
        String[] strs = {"aaa", "a", "aa"};
        String s = longestCommonPrefix1(strs);
        long endTime = new Date().getTime();
        System.out.println(s);
        System.out.println("time======" + (endTime - startTime));
    }

    private static String myDemo(String[] strs) {
        boolean isTrue = true;
        String rs = "";

        if (strs.length == 0) return rs;

        //拿第一个下标的字符串，从0下标开始，挨个和数组内的其他字符串进行对比
        for (int i = 1; i <= strs[0].length(); i++) {
            String temp = strs[0].substring(0, i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i) {
                    isTrue = false;
                    break;
                }

                if (!Objects.equals(temp, strs[j].substring(0, i))) {
                    isTrue = false;
                    break;
                }
            }
            if (!isTrue) break;
            rs = temp;
        }
        return rs;
    }

    private static String myDemo1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            int j = 1;
            for (; j <= prefix.length() && j <= strs[i].length(); j++) {
                if (!Objects.equals(prefix.substring(0, j), strs[i].substring(0, j))) {
                    break;
                }
            }
            j--;
            prefix = prefix.substring(0, j);

            if (Objects.equals(prefix, "")) return "";
        }
        return prefix;
    }

    private static String myDemo2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < strs[i].length() && j < ans.length(); j++) {
                //char是基础类型，可以使用==直接判定，使用equals效率更低
                //if(!Objects.equals(ans.charAt(j), strs[i].charAt(j))) break;
                if (ans.charAt(j) != strs[i].charAt(j)) break;

            }
            ans = ans.substring(0, j);
            if (Objects.equals(ans, "")) return "";
        }
        return ans;
    }

    /**
     * 水平扫描法
     * 时间复杂度：O(S)，S 是所有字符串中字符数量的总和。
     * 最坏的情况下，n 个字符串都是相同的。算法会将 s1 与其他字符串 [s2....sn] 都做一次比较。这样就会进行 S 次字符比较，其中 S 是输入数据中所有字符数量。
     * 空间复杂度：O(1)，我们只需要使用常数级别的额外空间。
     */
    private static String otherDemo(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    private static String otherDemo1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    /**
     * 分治法
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private static String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    /**
     * 二分查找法
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix1(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix1(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }
}