package com.wly.leetcode.leetboke;

/**
 * 数组翻转
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *  
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Rotate {
    public static void main(String[] args) {
        int[]nums={1,2,3,4,5,6,7};
        Rotate rotate = new Rotate();
        rotate.rotate1(nums, 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 计算新的下标对总长度取余即可
     * @param nums
     * @param k
     * @return
     */
    public void rotate(int[] nums, int k) {
        int[] newNums=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i]=nums[i];
        }
        for (int i = 0; i < newNums.length; i++) {
            int index=(i+k)%nums.length;
            nums[index]=newNums[i];
        }

    }

    /**
     * 官方答案1 代码更简洁 复制数组直接用arraycops会比for循环看着更简洁
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        int[] newNums=new int[length];
        for (int i = 0; i < length; i++) {
            newNums[(i+k)%length]=nums[i];
        }
        System.arraycopy(newNums,0,nums,0,length);

    }

    /**
     * 数组翻转
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 原始数组	1~2~3~4~5~6~71 2 3 4 5 6 7
     * 翻转所有元素	7~6~5~4~3~2~17 6 5 4 3 2 1
     * 翻转 [0, k\bmod n - 1][0,kmodn−1] 区间的元素	5~6~7~4~3~2~15 6 7 4 3 2 1
     * 翻转 [k\bmod n, n - 1][kmodn,n−1] 区间的元素	5~6~7~1~2~3~45 6 7 1 2 3 4
     *

     * @param nums
     * @param start
     * @param end
     */
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }


}
