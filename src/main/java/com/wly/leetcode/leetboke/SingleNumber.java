package com.wly.leetcode.leetboke;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums={4,1,2,1,2};
        SingleNumber singleNumber = new SingleNumber();
        int i = singleNumber.singleNumber1(nums);
        System.out.println(i);
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Object> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer key = Integer.valueOf(nums[i]);
            if(hashMap.containsKey(key)){
                hashMap.remove(key);
            }else {
                hashMap.put(key,null);
            }
        }
        Set<Map.Entry<Integer, Object>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, Object> entry : entries) {
            Integer key = entry.getKey();
            return key;
        }
        return 0;
    }

    /**
     * 官方答案 效率高很多 涨姿势
     * 答案是使用位运算。对于这道题，可使用异或运算 ^。异或运算有以下三个性质。
     *
     * 任何数和 00 做异或运算，结果仍然是原来的数，即 a^0=a。
     * 任何数和其自身做异或运算，结果是 00，即 a ^ a=0。
     * 异或运算满足交换律和结合律，即 a ^ b ^ a=b ^ a ^ a=b ^ (a ^ a)=b ^0=b
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums){
        int i=0;
        for (int num : nums) {
            i^=num;
        }
        return i;
    }
}
