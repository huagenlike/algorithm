package com.mzl.easy;

import com.alibaba.fastjson.JSONArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoSum
 * @Description: 两数之和
 * @Author may
 * @Date 2019/11/7 15:50
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class TwoSum {

    private static int[] nums = {2, 7, 11, 15};
    private static int target = 9;

    public static void main(String[] args) {
        int[] ints = myDemo();
        System.out.println(JSONArray.toJSON(ints));
//        int[] ints1 = otherDemo();
//        System.out.println(JSONArray.toJSON(ints1));

    }

    /**
     * 自己写的笨方法，为啥别人写的效率更高呢，就是基础的不扎实
     *
     * 时间复杂度是O(n^2),空间复杂度是O(1)；
     */
    public static int[] myDemo(){

        int[] indexs = new int[2];
        for(int i = 0; i < nums.length; i++){
            int temp1 = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                int temp2 = nums[j];
                if(temp1 + temp2 == target){
                    indexs[0] = i;
                    indexs[1] = j;
                }
            }
        }
        return indexs;
    }

    /**
     * 将数组值-数组下标作为键-值对
     * 在put之前，检验已经put进去的键当中，是否存在与当前即将put的数组值value满足target-value相等的情况
     * 若有，返回已经put进去的键对应的值以及当前的value对应的数组下标
     *
     * 时间复杂度也是O(n)，空间复杂度同样也是O(n)。
     */
    public static int[] otherDemo(){

        int[] indexs = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;

        for(int i = 0; i < len; i++){
            int temp = target - nums[i];
            //boolean containsKey(Object key)：测试是否存在于此映射中的键
            //boolean containsValue(Object value)：测试是否存在于此映射中的值
            if(map.containsKey(temp)){
                //通过key 获取 value，而 value 的值就是数组 nums 对应的下标
                indexs[0] = map.get(temp);
                indexs[1] = i;
                return indexs;
            }
            map.put(nums[i], i);
        }
        return indexs;
    }

}
