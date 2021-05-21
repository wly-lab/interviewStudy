package com.wly.leetcode.leetboke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Intersect {
    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        int[] num1={1,2,2,1};
        int[] num2={2,2};
        int[] intersect1 = intersect.intersect(num1, num2);
        for (int i : intersect1) {
            System.out.println(i);
        }
    }

    /**
     * 如果两个数组是有序的，则可以使用双指针的方法得到两个数组的交集。
     *
     * 首先对两个数组进行排序，然后使用两个指针遍历两个数组。
     *
     * 初始时，两个指针分别指向两个数组的头部。每次比较两个指针指向的两个数组中的数字，如果两个数字不相等，则将指向较小数字的指针右移一位，如果两个数字相等，将该数字添加到答案，并将两个指针都右移一位。当至少有一个指针超出数组范围时，遍历结束。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/liang-ge-shu-zu-de-jiao-ji-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i<nums1.length&&j<nums2.length){

            if(nums1[i]>nums2[j]){
                j+=1;
            }else if(nums1[i]<nums2[j]){
                i+=1;
            }else {
                list.add(nums1[i]);
                i+=1;
                j+=1;
            }
        }

        int[] ints = new int[list.size()];
        for (int i1 = 0; i1 < list.size(); i1++) {
            ints[i1]=list.get(i1);
        }
        return ints;
    }
}
